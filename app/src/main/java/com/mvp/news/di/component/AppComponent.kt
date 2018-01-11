package com.mvp.news.di.component

import com.mvp.news.di.module.AppModule
import com.mvp.news.di.module.MainModule
import com.mvp.news.di.module.UserModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun plus(mainModule: MainModule): MainComponent
    fun plus(userModule: UserModule): UserComponent
}