package by.gomel.marseille.goods.data.repository

import by.gomel.marseille.goods.data.database.DatabaseApi

class RepositoryApi(
        private val db: DatabaseApi
) : IRepository {
    override fun products() = ProductRepository(db.productDao())
    override fun services() = ServiceRepository(db.serviceDao())
}