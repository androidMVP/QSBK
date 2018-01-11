package com.mvp.comm.action

/**
 * Created by Administrator on 2017/9/22 0022.
 */
interface RxAction<T> {

     fun onSuccess(data: T)

     fun onError(code: Int, msg: String)
}