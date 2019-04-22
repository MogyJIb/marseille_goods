package by.gomel.marseille.goods.data.models

import java.io.Serializable

data class CartDto(
    var product: Product,
    var checked: Boolean,
    var count: Int
) : Serializable {

    val totalPrice: Double
        get() = count * product.price

}