package by.gomel.marseille.goods.presentation.product.list

import androidx.core.os.bundleOf
import by.gomel.marseille.goods.R
import by.gomel.marseille.goods.data.models.Product
import by.gomel.marseille.goods.data.models.ProductCategory
import by.gomel.marseille.goods.domain.product.GetProductsUseCase
import by.gomel.marseille.goods.presentation.base.view.BasePresenter
import io.reactivex.rxkotlin.plusAssign

class ProductListPresenter(
    private val getProductsUseCase: GetProductsUseCase
) : BasePresenter<ProductListContract.View>(), ProductListContract.Presenter {

    override fun initProducts(category: ProductCategory) {
        disposables += getProductsUseCase.getProductsFilteredByNameAsync(category)
            .subscribe({
                    products -> view?.updateProducts(products)
            }, this::handleError)
    }

    override fun onProductClick(product: Product)
            = view?.router()?.navigate(
                R.id.action_product_list_to_details,
                bundleOf("product" to product)
            ) ?: Unit

}