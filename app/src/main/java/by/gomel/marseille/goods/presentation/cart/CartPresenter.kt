package by.gomel.marseille.goods.presentation.cart

import by.gomel.marseille.goods.domain.ShoppingCart
import by.gomel.marseille.goods.domain.extentions.async
import by.gomel.marseille.goods.presentation.base.view.BasePresenter
import io.reactivex.Observable
import io.reactivex.rxkotlin.plusAssign


class CartPresenter(
        private val shoppingCart: ShoppingCart
) : BasePresenter<CartContract.View>(), CartContract.Presenter {
    override fun init() {
        disposables += Observable.just(shoppingCart.services())
                .async()
                .subscribe({
                    services -> view?.updateServices(services)
                }, this::handleError)

        disposables += Observable.just(shoppingCart.getTotalAmountString())
                .async()
                .subscribe({
                    amount -> view?.updateTotalAmount(amount)
                }, this::handleError)
    }

    override fun onDeleteButtonClicked() {
        shoppingCart.clear()
        view?.updateServices(emptyList())
        view?.updateTotalAmount("0.0 P")
    }
}