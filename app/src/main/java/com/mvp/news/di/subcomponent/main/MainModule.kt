package com.mvp.news.di.subcomponent.main

import com.mvp.news.api.API
import com.mvp.news.domain.usercase.artical.GetArticalCategoryTask
import com.mvp.news.repository.ArticalDataRepository
import com.mvp.news.repository.ArticalRepository
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
    fun provideArticalRepository(api: API): ArticalRepository {
        return ArticalDataRepository(api)
    }
}