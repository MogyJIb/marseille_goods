package by.gomel.marseille.goods.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.io.Serializable
import java.util.*


@Entity(tableName="products")
data class Product (
    @ColumnInfo(name="category")
    var category: ProductCategory,

    @ColumnInfo(name="name")
    var name: String,

    @ColumnInfo(name="price")
    var price: Double,

    @ColumnInfo(name = "uid")
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString()
): Serializable


enum class ProductCategory {
    ISRAEL,
    ITALY
}

class ProductCategoryTypeConverter {
    @TypeConverter
    fun toProductCategory(name: String) = ProductCategory.valueOf(name)

    @TypeConverter
    fun fromProductCategory(category: ProductCategory) = category.name
}