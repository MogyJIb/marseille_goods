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

    @ColumnInfo(name="imageUrl")
    var imageUrl: String,

    @ColumnInfo(name="description")
    var description: String,

    @ColumnInfo(name = "uid")
    @PrimaryKey
    var uid: String = UUID.randomUUID().toString()
): Serializable {

    constructor() : this(ProductCategory.ISRAEL, "", 0.0, "", "", "")

}



enum class ProductCategory(
    val title: String
) {
    ISRAEL("Израиль"),
    ITALY("Италия")
}

class ProductCategoryTypeConverter {
    @TypeConverter
    fun toProductCategory(name: String) = ProductCategory.valueOf(name)

    @TypeConverter
    fun fromProductCategory(category: ProductCategory) = category.name
}