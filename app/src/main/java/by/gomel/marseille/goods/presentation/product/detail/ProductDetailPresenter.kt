package by.gomel.marseille.goods.presentation.product.detail

import by.gomel.marseille.goods.data.models.Product
import by.gomel.marseille.goods.domain.ShoppingCart
import by.gomel.marseille.goods.presentation.base.view.BasePresenter

class ProductDetailPresenter(
    private val shoppingCart: ShoppingCart
) : BasePresenter<ProductDetailContract.View>(), ProductDetailContract.Presenter {

    override fun onAddToPurchaseClicked(product: Product) {
        view?.toast("\"${product.name}\" добавлено в корзину")
    }

}