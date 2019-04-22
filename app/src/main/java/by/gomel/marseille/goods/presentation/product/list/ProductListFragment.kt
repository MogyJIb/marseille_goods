package by.gomel.marseille.goods.presentation.product.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.DividerItemDecoration
import by.gomel.marseille.goods.R
import by.gomel.marseille.goods.data.models.Product
import by.gomel.marseille.goods.data.models.ProductCategory
import by.gomel.marseille.goods.presentation.BaseMainFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_product_list.*
import org.koin.android.ext.android.inject


class ProductListFragment : BaseMainFragment(), ProductListContract.View {

    override val presenter: ProductListContract.Presenter by inject()

    private lateinit var serviceAdapter: ProductAdapter
    private lateinit var category: ProductCategory

    companion object {
        @JvmStatic
        fun newInstance(category: ProductCategory) = ProductListFragment().apply {
            arguments = bundleOf("category" to category)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_product_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Init bottom app bar with button */
        bottomBarButton().run {
            hide(object : FloatingActionButton.OnVisibilityChangedListener() {
                override fun onHidden(fab: FloatingActionButton?) {
                    bottomBar().replaceMenu(R.menu.product_list_menu)
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

        category = arguments?.getSerializable("category") as ProductCategory
        setTitle(category.title)

        /* Init adapter and set up recycler view */
        serviceAdapter = ProductAdapter()
        serviceAdapter.onClickListener = presenter::onProductClick

        product_recycler_view.apply {
            adapter = serviceAdapter

            val dividerItemDecoration = DividerItemDecoration(
                context, DividerItemDecoration.VERTICAL)
            ContextCompat.getDrawable(context(), R.drawable.list_divider)?.let {
                dividerItemDecoration.setDrawable(it)
            }
            addItemDecoration(dividerItemDecoration)
        }

        presenter.initProducts(category)
    }

    override fun onDestroyView() {
        bottomBar().menu.clear()
        super.onDestroyView()
    }

    override fun updateProducts(products: List<Product>) = serviceAdapter.updateItems(products)

}