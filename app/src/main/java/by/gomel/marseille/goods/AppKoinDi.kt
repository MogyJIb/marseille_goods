package by.gomel.marseille.goods

import by.gomel.marseille.goods.data.database.DatabaseApi
import by.gomel.marseille.goods.data.repository.IRepository
import by.gomel.marseille.goods.data.repository.RepositoryApi
import by.gomel.marseille.goods.domain.ShoppingCart
import by.gomel.marseille.goods.domain.service.GetServicesUseCase
import by.gomel.marseille.goods.presentation.splash.view.SplashPresenter
import by.gomel.marseille.goods.domain.service.GetServiceCategoriesUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module


val dataModule = module {
    single { DatabaseApi.instance(androidContext()) }
    single { RepositoryApi(get()) as IRepository }
    single { ShoppingCart() }
}

val domainModule = module {
    single { GetServiceCategoriesUseCase(get()) }
    single { GetServicesUseCase(get()) }
}

val splashModule = module {
    factory { SplashPresenter(get()) }
}

val serviceModule = module {
    //factory { CategoryGridPresenter(get()) as CategoryGridContract.Presenter }
   // factory { CartPresenter(get()) as CartContract.Presenter }
   // factory { ServiceListPresenter(get(), get()) as ServiceListContract.Presenter }
}