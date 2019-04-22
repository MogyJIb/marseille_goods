package by.gomel.marseille.goods.presentation.base.view

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : Any> : BaseContract.Presenter {
    protected var view: V? = null
    protected lateinit var disposables: CompositeDisposable

    override fun bind(view: Any) {
        this.view = view as V
        disposables = CompositeDisposable()
        init()
    }

    override fun unbind() {
        view = null
        disposables.dispose()
    }
}