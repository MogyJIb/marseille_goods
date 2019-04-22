package by.gomel.marseille.goods.presentation.product.list

import by.gomel.marseille.goods.data.models.Product
import by.gomel.marseille.goods.data.models.ProductCategory
import by.gomel.marseille.goods.presentation.base.view.BaseContract


interface ProductListContract {

    interface View : BaseContract.View {
        fun updateProducts(products: List<Product>)
    }

    interface Presenter : BaseContract.Presenter {
        fun initProducts(category: ProductCategory)
        fun onProductClick(product: Product)
    }

}