package by.gomel.marseille.goods.presentation.cart

import by.gomel.marseille.goods.data.models.Service
import by.gomel.marseille.goods.presentation.base.view.BaseContract


interface CartContract {
    interface View : BaseContract.View {
        fun updateServices(services: List<Service>)
        fun updateTotalAmount(amount: String)
    }

    interface Presenter : BaseContract.Presenter {
        fun onDeleteButtonClicked()
    }
}