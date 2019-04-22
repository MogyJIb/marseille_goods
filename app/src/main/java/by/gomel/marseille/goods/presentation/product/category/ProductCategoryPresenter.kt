package by.gomel.marseille.goods.presentation.product.category

import androidx.core.os.bundleOf
import by.gomel.marseille.goods.R
import by.gomel.marseille.goods.data.models.ProductCategory
import by.gomel.marseille.goods.domain.product.GetProductCategoriesUseCase
import by.gomel.marseille.goods.presentation.base.view.BasePresenter
import io.reactivex.rxkotlin.plusAssign

class ProductCategoryPresenter(
    private val getServiceCategoriesUseCase: GetProductCategoriesUseCase
) : BasePresenter<ProductCategoryContract.View>(), ProductCategoryContract.Presenter {
    override fun init() {
        disposables += getServiceCategoriesUseCase.getCategoriesFilteredByNameAsync()
            .subscribe({
                    categories -> view?.updateCategories(categories)
            }, this::handleError)
    }

    override fun onCategoryItemClicked(category: ProductCategory)
            = view?.router()?.navigate(
                R.id.action_category_to_products,
                bundleOf("category" to category)
            ) ?: Unit
}