package by.gomel.marseille.goods.presentation.splash.view

import by.gomel.marseille.goods.presentation.base.view.BaseContract
import by.gomel.marseille.goods.presentation.base.view.BasePresenter
import by.gomel.marseille.goods.R
import by.gomel.marseille.goods.data.repository.IRepository
import by.gomel.marseille.goods.domain.extentions.async
import by.gomel.marseille.goods.domain.utils.fakeProducts
import by.gomel.marseille.goods.domain.utils.fakeServices
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit


class SplashPresenter(
        private val repository: IRepository
) : BasePresenter<BaseContract.View>() {

    override fun init() {
        disposables += Observable.zip(updateServices(), updateProducts(), BiFunction<Unit, Unit, Unit> { _, _ -> Unit })
            .delay(3, TimeUnit.SECONDS)
            .async()
            .subscribeBy {
                view?.router()?.navigate(R.id.action_splash_fragment_to_main_activity)
            }
    }

    private fun updateServices()
        = repository.services().getAll()
            .flatMap {services ->
                if (services.isEmpty())
                    repository.services().add(*fakeServices().toTypedArray())
                else
                    Observable.just(Unit)
            }

    private fun updateProducts()
            = repository.products().getAll()
                .flatMap {products ->
                    if (products.isEmpty())
                        repository.products().add(*fakeProducts().toTypedArray())
                    else
                        Observable.just(Unit)
                }
}