package com.mvp.comm.base

import com.mvp.comm.executor.PostExecutionThread
import com.mvp.comm.network.Result
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Administrator on 2018/3/26 0026.
 */
abstract class UseCase<T, Params>(val postExecutionThread: PostExecutionThread?) {


    private val disposables: CompositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(requestValues: Params?): Observable<Result<List<com.mvp.news.modle.Artist>>>


    open fun execute(observer: DisposableObserver<T>, params: Params) {
        val observable = buildUseCaseObservable(params)
                .map { t -> t.data }
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread?.getScheduler())
        disposables.add(observable.subscribeWith(observer))
    }


}