package by.gomel.marseille.goods.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import by.gomel.marseille.goods.data.models.Product
import by.gomel.marseille.goods.data.models.ProductCategoryTypeConverter
import by.gomel.marseille.goods.data.models.Service
import by.gomel.marseille.goods.data.models.ServiceCategoryTypeConverter


@Database(entities = [Product::class, Service::class], version = 1)
@TypeConverters(ServiceCategoryTypeConverter::class, ProductCategoryTypeConverter::class)
abstract class DatabaseApi : RoomDatabase() {
    companion object {
        private const val DATABASE_NAME = "marseille_db"

        @JvmStatic
        fun instance(context: Context) =
                Room.databaseBuilder(context, DatabaseApi::class.java, DATABASE_NAME).build()
    }

    abstract fun productDao(): ProductDao
    abstract fun serviceDao(): ServiceDao
}