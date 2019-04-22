package by.gomel.marseille.goods.data.repository


interface IRepository {
    fun products(): ProductRepository
    fun services(): ServiceRepository
}

