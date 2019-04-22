package by.gomel.marseille.goods.presentation.product.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import by.gomel.marseille.goods.R
import by.gomel.marseille.goods.data.models.Product
import by.gomel.marseille.goods.presentation.BaseMainFragment
import com.bumptech.glide.Glide
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_product_details.*
import org.koin.android.ext.android.inject

class ProductDetailFragment : BaseMainFragment(), ProductDetailContract.View {

    override val presenter: ProductDetailContract.Presenter by inject()

    private lateinit var product: Product

    companion object {
        @JvmStatic fun newInstance(product: Product) = ProductDetailFragment().apply {
            arguments = bundleOf("product" to product)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_product_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Init bottom app bar with button */
        bottomBarButton().run {
            hide(object : FloatingActionButton.OnVisibilityChangedListener() {
                override fun onHidden(fab: FloatingActionButton?) {
                    bottomBar().replaceMenu(R.menu.product_detail_menu)
                    bottomBar().fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER

                    setImageResource(R.drawable.outline_shopping_cart_white_24)
                    bottomBarButton().setOnClickListener { router().navigate(R.id.action_to_cart) }

                    show()
                }
            })
        }

        /* Init on menu item click listener */
        bottomBar().setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_back -> router().navigateUp()
                else -> false
            }
        }

        product = arguments?.getSerializable("product") as Product
        product.run {
            setTitle(name)
            product_description.text = description
            runCatching { Glide.with(this@ProductDetailFragment).load(imageUrl).into(product_icon) }
            product_price.text = "$price BIN"
        }

        button_add_purchase.setOnClickListener {
            presenter.onAddToPurchaseClicked(product)
        }
    }

}