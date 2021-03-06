package by.gomel.marseille.goods.presentation.cart

import by.gomel.marseille.goods.data.models.CartDto
import by.gomel.marseille.goods.presentation.base.view.BaseContract


interface CartContract {

    interface View : BaseContract.View {
        fun updateCartDtoList(services: List<CartDto>)
        fun updateTotalAmount(amount: String)
    }

    interface Presenter : BaseContract.Presenter {
        fun onClearButtonClicked()
        fun onItemDeleteButtonClicked(cardDto: CartDto)
    }

}