package com.mvp.news.di.subcomponent.artical

import com.mvp.news.repository.ArticalDataRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2018/3/27 0027.
 */

@Module
class ArticalModule {

    @Provides
    fun provideArticalRepository() = ArticalDataRepository()

}
