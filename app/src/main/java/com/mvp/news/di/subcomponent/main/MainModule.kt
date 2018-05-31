package com.mvp.news.di.subcomponent.main

import com.mvp.news.ui.present.MainPresent
import com.mvp.news.ui.view.MainView
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Module
class MainModule(val view: MainView) {

    @Provides
    fun provideMainView(): MainView = view

    @Provides
    fun provideMainPresent(mainView: MainView) = MainPresent(mainView)


}