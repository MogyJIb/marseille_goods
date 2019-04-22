package by.gomel.marseille.goods.domain.service

import by.gomel.marseille.goods.data.models.Service
import by.gomel.marseille.goods.data.models.ServiceCategory
import by.gomel.marseille.goods.data.repository.IRepository
import by.gomel.marseille.goods.domain.extentions.async
import io.reactivex.Observable

class GetServicesUseCase(
        private val repository: IRepository
) {
    fun getServicesFilteredByNameAsync(category: ServiceCategory): Observable<List<Service>>
            = repository.services().get(category)
            .flatMap { list ->
                Observable.fromIterable(list)
                        .sorted(compareBy { service -> service.name })
                        .toList()
                        .toObservable()
            }
            .onErrorReturn { emptyList() }
            .async()
}