package by.gomel.marseille.goods.domain.product

import by.gomel.marseille.goods.data.models.Product
import by.gomel.marseille.goods.data.models.ProductCategory
import by.gomel.marseille.goods.data.models.Service
import by.gomel.marseille.goods.data.models.ServiceCategory
import by.gomel.marseille.goods.data.repository.IRepository
import by.gomel.marseille.goods.domain.extentions.async
import io.reactivex.Observable

class GetProductsUseCase(
        private val repository: IRepository
) {
    fun getProductsFilteredByNameAsync(category: ProductCategory): Observable<List<Product>>
            = repository.products().get(category)
            .flatMap { list ->
                Observable.fromIterable(list)
                        .sorted(compareBy { service -> service.name })
                        .toList()
                        .toObservable()
            }
            .onErrorReturn { emptyList() }
            .async()
}