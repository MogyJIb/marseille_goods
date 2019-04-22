package by.gomel.marseille.goods.presentation.product.detail

import by.gomel.marseille.goods.data.models.Product
import by.gomel.marseille.goods.presentation.base.view.BaseContract

interface ProductDetailContract {

    interface View : BaseContract.View
    interface Presenter : BaseContract.Presenter {
        fun onAddToPurchaseClicked(product: Product)
    }

}