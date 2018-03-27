package com.mvp.comm.base

import kotlin.system.exitProcess

/**
 * Created by Administrator on 2018/3/26 0026.
 */
abstract class UseCase<in Q : UseCase.RequestValues, in P : UseCase.ResponseValue> {


    private var requestValues: Q? = null

    private var useCaseCallback: UseCaseCallback<P>? = null

    fun run() {
        executeUseCase(requestValues)
    }

    abstract fun executeUseCase(requestValues: Q?)

    interface RequestValues

    interface ResponseValue

    interface UseCaseCallback<R> {
        fun onSuccess(response: R)

        fun onError()
    }

}