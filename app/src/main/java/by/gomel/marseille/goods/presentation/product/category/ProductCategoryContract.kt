package by.gomel.marseille.goods.presentation.product.category

import by.gomel.marseille.goods.data.models.ProductCategory
import by.gomel.marseille.goods.presentation.base.view.BaseContract

interface ProductCategoryContract {
    interface View : BaseContract.View {
        fun updateCategories(categories: List<ProductCategory>)
    }

    interface Presenter : BaseContract.Presenter {
        fun onCategoryItemClicked(category: ProductCategory)
    }
}