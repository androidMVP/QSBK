package com.mvp.news.di.subcomponent.main

import com.mvp.news.di.subcomponent.artical.ArticalModule
import com.mvp.news.ui.fragment.IndexFragment
import com.mvp.news.ui.activity.MainActivity
import com.mvp.news.ui.fragment.ArticalFragment
import dagger.Subcomponent

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {

    fun injectTo(indexFragment: IndexFragment)
}