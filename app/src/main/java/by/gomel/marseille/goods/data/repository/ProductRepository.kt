package by.gomel.marseille.goods.data.repository

import by.gomel.marseille.goods.data.database.ProductDao
import by.gomel.marseille.goods.data.models.Product
import by.gomel.marseille.goods.data.models.ProductCategory
import io.reactivex.Observable


class ProductRepository(
        private val productDao: ProductDao
) {
    fun getAll(): Observable<List<Product>> = Observable.fromCallable { productDao.getAll() }

    fun get(vararg productIds: String): Observable<List<Product>>
            = Observable.fromCallable { productDao.get(*productIds) }

    fun findByCategory(category: ProductCategory): Observable<List<Product>>
            = Observable.fromCallable { productDao.findByCategory(category) }

    fun add(vararg products: Product): Observable<Unit> = Observable.fromCallable { productDao.insert(*products) }

    fun update(vararg products: Product): Observable<Unit>
            = Observable.fromCallable { productDao.update(*products) }

    fun delete(vararg products: Product): Observable<Unit>
            = Observable.fromCallable { productDao.delete(*products) }

    fun delete(vararg productIds: String): Observable<Unit>
            = Observable.fromCallable { productDao.delete(*productIds) }

    fun categories(): Observable<List<ProductCategory>>
            = Observable.fromCallable { ProductCategory.values().toList() }
}