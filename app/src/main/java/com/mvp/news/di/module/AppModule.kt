package com.mvp.news.di.module

import android.content.Context
import com.mvp.comm.network.AppRetrofit
import com.mvp.news.App
import com.mvp.news.api.API
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Module
@Singleton
class AppModule(private val app: App){

    @Provides @Singleton
    fun provideApplicationContext(): Context = app


    @Provides @Singleton
    fun provideAPI() = AppRetrofit.getApiService(API::class.java)




}