package by.gomel.marseille.goods

import android.app.Application
import org.koin.android.ext.android.startKoin


class MarseilleApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
                dataModule,
                domainModule,
                splashModule,
                serviceModule
        ))
    }
}