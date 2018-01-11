package com.mvp.comm.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.mvp.comm.base.AppUtil

/**
 * Created by Administrator on 2017/8/25 0025.
 */


private fun getActiveNetworkInfo(): NetworkInfo {
    val systemService = AppUtil.applicaion.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return systemService.activeNetworkInfo
}

fun isConnected() = getActiveNetworkInfo().isConnected