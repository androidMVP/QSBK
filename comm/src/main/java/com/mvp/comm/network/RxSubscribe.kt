package com.mvp.comm.network

import com.mvp.comm.utils.isConnected
import rx.Subscriber

/**
 * Created by Administrator on 2017/8/25 0025.
 */
abstract class RxSubscribe<T> : Subscriber<T>() {


    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onCompleted() {

    }

    override fun onError(e: Throwable?) {
        if (!isConnected()) {
            this.onError(RetCodeEnum.NET_WORK_ERROR.code, RetCodeEnum.NET_WORK_ERROR.message)
        } else if (e is BllException) {
            this.onError(e.code, e.msg)
        } else {
            this.onError(RetCodeEnum.APP_ERROR.code, RetCodeEnum.APP_ERROR.message)
        }
    }

    abstract fun onSuccess(data: T)

    abstract fun onError(code: Int, msg: String)

}