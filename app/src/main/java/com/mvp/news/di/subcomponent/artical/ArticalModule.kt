package com.mvp.news.di.subcomponent.artical

import com.mvp.comm.executor.PostExecutionThread
import com.mvp.news.api.API
import com.mvp.news.domain.usercase.artical.GetArticalListTask
import com.mvp.news.repository.ArticalDataRepository
import com.mvp.news.repository.ArticalRepository
import com.mvp.news.ui.present.ArticalPresent
import com.mvp.news.ui.view.ArticalView
import com.mvp.news.ui.view.MainView
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2018/3/27 0027.
 */

@Module
class ArticalModule(val articalView: ArticalView) {

    @Provides
    fun provideArticalRepository(api: API): ArticalRepository {
        return ArticalDataRepository(api)
    }

    @Provides
    fun provideArticalView(): ArticalView = articalView





}
