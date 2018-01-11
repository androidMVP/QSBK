package com.mvp.news.di.module

import com.mvp.news.api.API
import com.mvp.news.repository.CategoryBll
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
    fun provideAndroidBll(api: API) = CategoryBll(api)


    @Provides
    fun provideMainView(): MainView = view

    @Provides
    fun provideMainPresent(mainView: MainView, androidBll: CategoryBll) = MainPresent(mainView, androidBll)


}