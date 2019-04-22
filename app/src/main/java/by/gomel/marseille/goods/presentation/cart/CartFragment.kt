package by.gomel.marseille.goods.presentation.cart

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import by.gomel.marseille.goods.R
import by.gomel.marseille.goods.data.models.CartDto
import by.gomel.marseille.goods.domain.extentions.hide
import by.gomel.marseille.goods.domain.extentions.show
import by.gomel.marseille.goods.presentation.BaseMainFragment
import by.gomel.marseille.goods.presentation.InfoDialog
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_cart.*
import org.koin.android.ext.android.inject


class CartFragment : BaseMainFragment(), CartContract.View {

    override val presenter: CartContract.Presenter by inject()

    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_cart, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle("Корзина")

        /* Init bottom app bar with button */
        bottomBarButton().run {
            hide(object : FloatingActionButton.OnVisibilityChangedListener() {
                override fun onHidden(fab: FloatingActionButton?) {
                    bottomBar().replaceMenu(R.menu.cart_menu)
                    bottomBar().fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END

                    setImageResource(R.drawable.outline_arrow_back_ios_white_24)
                    bottomBarButton().setOnClickListener { router().navigateUp() }

                    show()
                }
            })
        }

        /* Init on menu item click listener */
        bottomBar().setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_delete -> {
                    InfoDialog.newInstance(
                            title = "Очистка корзины",
                            message = "Вы действительно хотите очистить корзину?",
                            leftButtonCaption = getString(R.string.cancel),
                            rightButtonCaption = getString(R.string.resume)
                    ).apply {
                        rightButtonListener = DialogInterface.OnClickListener { _, _ ->
                            presenter.onClearButtonClicked()
                        }
                    }.show(fragmentManager, InfoDialog::class.java.simpleName)
                    true
                }
                else -> false
            }
        }

        /* Init adapter and set up recycler view */
        cartAdapter = CartAdapter()

        cart_recycler_view.apply {
            adapter = cartAdapter

            val dividerItemDecoration = DividerItemDecoration(
                    context, DividerItemDecoration.VERTICAL)
            ContextCompat.getDrawable(context(), R.drawable.list_divider)?.let {
                dividerItemDecoration.setDrawable(it)
            }
            addItemDecoration(dividerItemDecoration)
        }

        button_buy.setOnClickListener {
            OrderDialogFragment.newInstance().apply {
                rightButtonListener = DialogInterface.OnClickListener { _, _ ->
                    this@CartFragment.toast("Ваш заказ успешно оформлен, ожидайте обратной связи")
                    router().navigateUp()
                }
            }.show(fragmentManager, InfoDialog::class.java.simpleName)
        }
    }

    override fun onDestroyView() {
        bottomBar().menu.clear()
        super.onDestroyView()
    }

    override fun updateCartDtoList(services: List<CartDto>) {
        if (services.isEmpty())
            empty_view.show()
        else
            empty_view.hide()

        cartAdapter.updateItems(services)
    }

    override fun updateTotalAmount(amount: String) { amount_text_view.text = amount }

}