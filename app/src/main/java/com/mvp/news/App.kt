package com.mvp.news

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.mvp.comm.base.AppUtil
import com.mvp.news.di.component.AppComponent
import com.mvp.news.di.component.DaggerAppComponent
import com.mvp.news.di.module.AppModule

/**
 * Created by Administrator on 2017/8/23 0023.
 */
    class App : MultiDexApplication() {

    companion object {
        lateinit var graph: AppComponent
    }

    override fun onCreate() {
        AppUtil.initApp(this)
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        graph = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}