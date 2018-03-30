package com.mvp.news.di.component

import com.mvp.news.di.module.AppModule
import com.mvp.news.di.subcomponent.user.UserModule
import com.mvp.news.di.subcomponent.artical.ArticalModule
import com.mvp.news.di.subcomponent.artical.ArticalModuleComponent
import com.mvp.news.di.subcomponent.user.UserComponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun plus(userModule: UserModule): UserComponent
    fun plus(articalModule: ArticalModule): ArticalModuleComponent
}