package by.gomel.marseille.goods.domain

import by.gomel.marseille.goods.data.models.CartDto
import by.gomel.marseille.goods.data.models.Product
import io.reactivex.subjects.BehaviorSubject
import java.io.Serializable


class ShoppingCart : Serializable {

    private val cartDtoMap: MutableMap<String, CartDto> = mutableMapOf()

    val amount: BehaviorSubject<Double> = BehaviorSubject.create()
    val cartDtoList: List<CartDto>
        get() = cartDtoMap.values.toList()

    fun add(vararg products: Product) {
        products.forEach { product ->
            if (this.cartDtoMap.containsKey(product.uid)) {
                cartDtoMap[product.uid]?.let { cartDto ->
                    cartDto.count++
                }
            } else {
                this.cartDtoMap[product.uid] = CartDto(product, true, 1)
            }
        }
        updateAmount()
    }

    fun add(vararg cartDtoList: CartDto) {
        cartDtoList.forEach { cartDto ->
            cartDtoMap[cartDto.product.uid] = cartDto
        }
        updateAmount()
    }

    fun update(vararg products: Product) {
        add(*products)
    }

    fun update(vararg cartDtoList: CartDto) {
        cartDtoList.forEach { cartDto ->
            cartDtoMap[cartDto.product.uid] = cartDto
        }
        updateAmount()
    }

    fun remove(vararg cartDtoList: CartDto) {
        cartDtoList.forEach { cartDto ->
            cartDtoMap.remove(cartDto.product.uid)
        }
        updateAmount()
    }

    fun remove(vararg products: Product) {
        products.forEach { product ->
            this.cartDtoMap.remove(product.uid)
        }
        updateAmount()
    }

    fun clear() {
        cartDtoMap.clear()
        updateAmount()
    }

    private fun updateAmount() {
        var amount = 0.0
        cartDtoMap.values.forEach { cartDto ->
            if (cartDto.checked) amount += cartDto.product.price * cartDto.count
        }
        this.amount.onNext(amount)
    }

}