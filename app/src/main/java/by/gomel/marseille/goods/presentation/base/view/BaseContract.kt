package by.gomel.marseille.goods.presentation.base.view

import android.content.Context
import androidx.navigation.NavController

interface BaseContract {
    /**
     * Base presenter
     */
    interface Presenter {
        fun init() {}
        fun bind(view: Any)
        fun unbind() {}
        fun handleError(error: Throwable) {
            println("${this.javaClass.simpleName}\n${error.message}")
            error.printStackTrace()
        }
    }

    /**
     * Base view
     */
    interface View : Router {
        fun context(): Context
        fun toast(text: String)
    }

    /**
     * Base router
     */
    interface Router {
        fun router(): NavController
    }
}