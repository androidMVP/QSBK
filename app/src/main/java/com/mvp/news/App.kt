package com.mvp.news

import android.app.Application
import com.mvp.comm.base.AppUtil
import com.mvp.news.di.component.AppComponent
import com.mvp.news.di.component.DaggerAppComponent
import com.mvp.news.di.module.AppModule

/**
 * Created by Administrator on 2017/8/23 0023.
 */
class App : Application() {

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
}