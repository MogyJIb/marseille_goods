package by.gomel.marseille.goods.domain

import by.gomel.marseille.goods.data.models.Service
import java.io.Serializable

class ShoppingCart : Serializable {
    private val services: MutableSet<Service> = mutableSetOf()

    fun add(vararg service: Service) = services.addAll(service)
    fun add(services: MutableList<Service>) = this.services.addAll(services)
    fun clear() = services.clear()
    fun services() = services.toList()
    fun getTotalAmount(): Pair<Double, Double> {
        var minPrice = 0.0
        var maxPrice = 0.0

        services.forEach { service ->
            minPrice += service.minPrice
            maxPrice += if (service.maxPrice > 0) service.maxPrice else service.minPrice
        }

        return minPrice to maxPrice
    }

    fun getTotalAmountString() = "${getTotalAmount().first}" +
            if (getTotalAmount().second > 0) " - ${getTotalAmount().second}" else ""
}