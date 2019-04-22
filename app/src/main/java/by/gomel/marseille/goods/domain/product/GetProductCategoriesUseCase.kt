package by.gomel.marseille.goods.domain.product

import by.gomel.marseille.goods.data.models.ProductCategory
import by.gomel.marseille.goods.data.models.ServiceCategory
import by.gomel.marseille.goods.data.repository.IRepository
import by.gomel.marseille.goods.domain.extentions.async
import io.reactivex.Observable

class GetProductCategoriesUseCase(
        private val repository: IRepository
) {
    fun getCategoriesFilteredByNameAsync(): Observable<List<ProductCategory>>
            = repository.products().categories()
                    .flatMap { list ->
                        Observable.fromIterable(list)
                                .sorted(compareBy { category -> category.name })
                                .toList()
                                .toObservable()
                    }
                    .onErrorReturn { emptyList() }
                    .async()
}