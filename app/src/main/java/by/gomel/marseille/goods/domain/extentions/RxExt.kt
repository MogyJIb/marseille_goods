package by.gomel.marseille.goods.domain.extentions

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <T> Observable<T>.async(): Observable<T>
        = this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.async(): Single<T>
        = this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.async(): Flowable<T>
        = this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

fun <T> Maybe<T>.async(): Maybe<T>
        = this.subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())

