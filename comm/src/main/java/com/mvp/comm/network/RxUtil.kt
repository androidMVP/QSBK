package com.mvp.comm.network

import rx.Observable
import rx.Observable.Transformer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Administrator on 2017/8/24 0024.
 */


fun <T> transResult(): Transformer<Result<T>, T> {
    return Transformer<Result<T>, T> { tObservable ->
        tObservable.flatMap { t -> createData(t.data) }
    }
}

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
            subscriber.onCompleted()
        } catch (var3: Exception) {
            subscriber.onError(var3)
        }
    }

}

