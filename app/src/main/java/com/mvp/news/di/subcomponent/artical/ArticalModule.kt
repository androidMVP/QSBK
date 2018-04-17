package com.mvp.news.di.subcomponent.artical

import com.mvp.comm.executor.PostExecutionThread
import com.mvp.news.api.API
import com.mvp.news.domain.usercase.artical.GetArticalListTask
import com.mvp.news.repository.ArticalDataRepository
import com.mvp.news.repository.ArticalRepository
import com.mvp.news.ui.present.ArticalPresent
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2018/3/27 0027.
 */

@Module
class ArticalModule {

    @Provides
    fun provideArticalRepository(api: API): ArticalRepository {
        return ArticalDataRepository(api)
    }


    @Provides
    fun provideGetArticalListTask( articalRepository: ArticalRepository, postExecutionThread: PostExecutionThread): GetArticalListTask {
        return GetArticalListTask(articalRepository,postExecutionThread)
    }

    @Provides
    fun provideArticalArticalPresent(getArticalListTask: GetArticalListTask) = ArticalPresent(getArticalListTask)


}
