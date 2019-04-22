package by.gomel.marseille.goods.presentation.cart

import by.gomel.marseille.goods.data.models.CartDto
import by.gomel.marseille.goods.domain.ShoppingCart
import by.gomel.marseille.goods.presentation.base.view.BasePresenter

class CartItemPresenter(
    private val shoppingCart: ShoppingCart
) : BasePresenter<CartItemContract.View>(), CartItemContract.Presenter {

    override fun updateCartWithItem(cardDto: CartDto) {
        shoppingCart.update(cardDto)
    }

    override fun onItemDeleteButtonClicked(cardDto: CartDto) {
        shoppingCart.remove(cardDto)
    }

}
