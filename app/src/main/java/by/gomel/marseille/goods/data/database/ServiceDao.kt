package by.gomel.marseille.goods.data.database

import androidx.room.*
import by.gomel.marseille.goods.data.models.Service
import by.gomel.marseille.goods.data.models.ServiceCategory


@Dao
interface ServiceDao {
    @Query("SELECT * FROM services")
    fun getAll(): List<Service>

    @Query("SELECT * FROM services WHERE uid IN (:serviceIds)")
    fun get(vararg serviceIds: String): List<Service>

    @Query("SELECT * FROM services WHERE category LIKE :category")
    fun get(category: ServiceCategory): List<Service>

    @Insert
    fun insert(vararg services: Service)

    @Update
    fun update(vararg services: Service)

    @Delete
    fun delete(vararg services: Service)

    @Query("DELETE FROM services WHERE uid IN (:serviceIds)")
    fun delete(vararg serviceIds: String)
}