package by.gomel.marseille.goods.data.database

import androidx.room.*
import by.gomel.marseille.goods.data.models.Product
import by.gomel.marseille.goods.data.models.ProductCategory


@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    fun getAll(): List<Product>

    @Query("SELECT * FROM products WHERE uid IN (:productIds)")
    fun get(vararg productIds: String): List<Product>

    @Query("SELECT * FROM products WHERE category LIKE :category")
    fun findByCategory(category: ProductCategory): List<Product>

    @Insert
    fun insert(vararg products: Product)

    @Update
    fun update(vararg products: Product)

    @Delete
    fun delete(vararg products: Product)

    @Query("DELETE FROM products WHERE uid IN (:productIds)")
    fun delete(vararg productIds: String)
}