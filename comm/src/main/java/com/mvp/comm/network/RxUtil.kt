package com.mvp.comm.network

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Administrator on 2017/8/24 0024.
 */


fun <R> Observable<Result<R>>.composessssss(): Observable<R> {
    return this.flatMap { t ->
        if (!t.error)
            createData(t.results)
        else
            Observable.error(BllException(110, "服务出错了"))
    }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> createData(data: T?): Observable<T> {
    return Observable.create { subscriber ->
        try {
            subscriber.onNext(data)
            subscriber.onComplete()
        } catch (var3: Exception) {
            subscriber.onError(var3)
        }
    }

}

