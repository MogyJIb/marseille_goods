package by.gomel.marseille.goods.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.io.Serializable
import java.util.*

@Entity(tableName="services")
data class Service (
    @ColumnInfo(name="category")
    var category: ServiceCategory,

    @ColumnInfo(name="name")
    var name: String,

    @ColumnInfo(name="minPrice")
    var minPrice: Double,

    @ColumnInfo(name="maxPrice")
    var maxPrice: Double,

    @ColumnInfo(name = "uid")
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString()
): Serializable {
    val price: String
        get() = "$minPrice" + (if (maxPrice < 0) "" else " - $maxPrice") + " P"
}



enum class ServiceCategory(
        val title: String
) {
    HAIR("Парикмахерские услуги"),
    MANICURE("Маникюр"),
    PEDICURE("Педикюр"),
    MAKE_UP("Макияж"),
    MAGIC_WHITE("Косметическое отбеливание зубов"),
    TOOL_SHARPENING("Заточка парикмахерского и маникюрного инструмента")
}


class ServiceCategoryTypeConverter {
    @TypeConverter
    fun toServiceCategory(name: String) = ServiceCategory.valueOf(name)

    @TypeConverter
    fun fromServiceCategory(category: ServiceCategory) = category.name
}