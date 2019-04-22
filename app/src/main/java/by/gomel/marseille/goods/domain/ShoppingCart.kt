package by.gomel.marseille.goods.domain

import by.gomel.marseille.goods.data.models.Product
import io.reactivex.subjects.BehaviorSubject
import java.io.Serializable


class ShoppingCart : Serializable {
    
    private val products: MutableMap<String, Product> = mutableMapOf()
    private val count: MutableMap<String, Int> = mutableMapOf()
    val amount: BehaviorSubject<Double> = BehaviorSubject.create()

    fun add(vararg products: Product) {
        products.forEach { product ->
            if (this.products.containsKey(product.uid)) {
                this.count[product.uid] = this.count[product.uid]!! + 1
            } else {
                this.products[product.uid] = product
                this.count[product.uid] = 1
            }
        }
        updateAmount()
    }

    fun remove(vararg products: Product) {
        products.forEach { product ->
            this.products.remove(product.uid)
            this.count.remove(product.uid)
        }
        updateAmount()
    }

    fun clear() {
        products.clear()
        count.clear()
        updateAmount()
    }

    private fun updateAmount() {
        var amount = 0.0
        products.values.forEach { product ->
            amount += product.price * count[product.uid]!!
        }
        this.amount.onNext(amount)
    }

}