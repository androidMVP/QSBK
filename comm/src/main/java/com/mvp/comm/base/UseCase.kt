package com.mvp.comm.base

import com.mvp.comm.network.Result
import com.mvp.comm.network.composessssss
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposables
import io.reactivex.observers.DisposableObserver
import kotlin.system.exitProcess

/**
 * Created by Administrator on 2018/3/26 0026.
 */
abstract class UseCase<T, Params> {


    private val disposables: CompositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(requestValues: Params?): Observable<Result<T>>


    open fun execute(params: Params) {
       val observer= buildUseCaseObservable(params).composessssss()
        disposables.add(observer)
    }

}