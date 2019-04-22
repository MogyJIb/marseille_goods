package by.gomel.marseille.goods.presentation.cart

import by.gomel.marseille.goods.data.models.CartDto
import by.gomel.marseille.goods.domain.ShoppingCart
import by.gomel.marseille.goods.domain.extentions.async
import by.gomel.marseille.goods.presentation.base.view.BasePresenter
import io.reactivex.Observable
import io.reactivex.rxkotlin.plusAssign


class CartPresenter(
        private val shoppingCart: ShoppingCart
) : BasePresenter<CartContract.View>(), CartContract.Presenter {

    override fun init() {
        disposables += Observable.just(shoppingCart.cartDtoList)
                .async()
                .subscribe({
                        cartDtoList -> view?.updateCartDtoList(cartDtoList)
                }, this::handleError)

        disposables += shoppingCart.amount
                .async()
                .subscribe({
                    amount -> view?.updateTotalAmount("$amount BIN")
                }, this::handleError)
    }

    override fun onClearButtonClicked() {
        shoppingCart.clear()
        view?.updateCartDtoList(shoppingCart.cartDtoList)
    }

    override fun onItemDeleteButtonClicked(cardDto: CartDto) {
        shoppingCart.remove(cardDto)
        view?.updateCartDtoList(shoppingCart.cartDtoList)
    }

}