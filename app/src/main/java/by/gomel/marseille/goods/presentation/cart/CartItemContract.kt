package by.gomel.marseille.goods.presentation.cart

import by.gomel.marseille.goods.data.models.CartDto
import by.gomel.marseille.goods.presentation.base.view.BaseContract

interface CartItemContract {

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter {
        fun onItemDeleteButtonClicked(cardDto: CartDto)
        fun updateCartWithItem(cardDto: CartDto)
    }

}