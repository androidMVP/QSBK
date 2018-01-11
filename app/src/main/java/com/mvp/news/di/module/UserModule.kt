package com.mvp.news.di.module

import com.mvp.news.api.API
import com.mvp.news.repository.UserBll
import com.mvp.news.ui.present.MsgCodePresent
import com.mvp.news.ui.view.MsgCodeView
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2017/9/21 0021.
 */
@Module
class UserModule(val msgCodeView: MsgCodeView) {

    @Provides
    fun provideUserBll(api: API) = UserBll(api)

    @Provides
    fun provideMsgCodeView() :MsgCodeView= msgCodeView

    @Provides
    fun provideMsgCodePresent(userBll: UserBll) = MsgCodePresent(userBll, msgCodeView)
}