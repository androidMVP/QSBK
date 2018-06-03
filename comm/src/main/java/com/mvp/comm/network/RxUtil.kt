package com.mvp.comm.network

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Administrator on 2017/8/24 0024.
 */


fun <R> Observable<Result<R>>.composessssss(): Observable<R> {
    return this.flatMap { t ->
        if (t.code == 0)
            createData(t.data)
        else
            Observable.error(BllException(t.code, t.msg ?: "系统异常"))
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

