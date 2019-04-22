package by.gomel.marseille.goods.presentation.splash.view

import by.gomel.marseille.goods.presentation.base.view.BaseContract
import by.gomel.marseille.goods.presentation.base.view.BasePresenter
import by.gomel.marseille.goods.R
import by.gomel.marseille.goods.data.repository.IRepository
import by.gomel.marseille.goods.domain.extentions.async
import by.gomel.marseille.goods.domain.utils.fakeServices
import io.reactivex.Observable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit


class SplashPresenter(
        private val repository: IRepository
) : BasePresenter<BaseContract.View>() {
    override fun init() {
        disposables += repository.services().getAll()
                .flatMap {services ->
                    if (services.isEmpty())
                        repository.services().add(*fakeServices().toTypedArray())
                    else
                    Observable.just(Unit)
                }
                .delay(3, TimeUnit.SECONDS)
                .async()
                .subscribeBy {
                    view?.router()?.navigate(R.id.action_splash_fragment_to_main_activity)
                }
    }
}