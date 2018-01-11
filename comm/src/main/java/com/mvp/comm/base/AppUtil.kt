package com.mvp.comm.base

import android.app.Application

/**
 * Created by Administrator on 2017/8/23 0023.
 */
object AppUtil {

    lateinit var applicaion: Application

    fun initApp(app: Application) {
        applicaion = app
    }


}