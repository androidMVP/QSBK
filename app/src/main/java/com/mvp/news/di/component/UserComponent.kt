package com.mvp.news.di.component

import com.mvp.news.di.module.UserModule
import com.mvp.news.ui.activity.MsgCodeActivity
import dagger.Subcomponent

/**
 * Created by Administrator on 2017/9/21 0021.
 */
@Subcomponent(modules = arrayOf(UserModule::class))
interface UserComponent {

    fun injectTo(msgCodeActivity: MsgCodeActivity)
}