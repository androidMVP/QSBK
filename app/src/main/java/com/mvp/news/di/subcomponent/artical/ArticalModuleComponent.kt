package com.mvp.news.di.subcomponent.artical

import com.mvp.news.di.module.UserModule
import com.mvp.news.ui.activity.MsgCodeActivity
import com.mvp.news.ui.fragment.ArticalFragment
import dagger.Subcomponent

/**
 * Created by Administrator on 2018/3/27 0027.
 */

@Subcomponent(modules = arrayOf(ArticalModule::class))
interface ArticalModuleComponent {

    fun injectTo(articalFragment: ArticalFragment)
}