package com.mvp.comm.base

import com.mvp.comm.network.AppRetrofit

/**
 * Created by Administrator on 2017/8/23 0023.
 */
 open class BaseBll {

     inline fun <reified T> loadService() = AppRetrofit.getApiService(T::class.java)
}