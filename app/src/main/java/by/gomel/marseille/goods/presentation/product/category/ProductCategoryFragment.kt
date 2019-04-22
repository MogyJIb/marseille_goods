package by.gomel.marseille.goods.presentation.product.category


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.gomel.marseille.goods.R
import by.gomel.marseille.goods.data.models.ProductCategory
import by.gomel.marseille.goods.presentation.BaseMainFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_category_grid.*
import org.koin.android.ext.android.inject


class ProductCategoryFragment : BaseMainFragment(), ProductCategoryContract.View {

    override val presenter: ProductCategoryContract.Presenter by inject()

    private lateinit var productCategoryAdapter: ProductCategoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_product_category, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle("Продукция")

        /* Init bottom app bar with button */
        bottomBarButton().run {
            hide(object : FloatingActionButton.OnVisibilityChangedListener() {
                override fun onHidden(fab: FloatingActionButton?) {
                    bottomBar().menu.clear()
                    bottomBar().fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER

                    setImageResource(R.drawable.outline_shopping_cart_white_24)
                    // TODO bottomBarButton().setOnClickListener { router().navigate(R.id.action_to_cart) }

                    show()
                }
            })
        }

        /* Init adapter and set up recycler view */
        productCategoryAdapter = ProductCategoryAdapter()
        productCategoryAdapter.onClickListener = presenter::onCategoryItemClicked

        category_recycler_view.adapter = productCategoryAdapter
    }

    override fun updateCategories(categories: List<ProductCategory>)
            = productCategoryAdapter.updateItems(categories)

}