package com.mvp.news.di.component

import com.mvp.news.di.module.MainModule
import com.mvp.news.ui.activity.IndexFragment
import com.mvp.news.ui.activity.MainActivity
import com.mvp.news.ui.fragment.AndroidFragment
import com.mvp.news.ui.fragment.ArticalFragment
import dagger.Subcomponent

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {

    fun injectTo(mainActivity: MainActivity)

    fun injectTo(mainFragment: AndroidFragment)

    fun injectTo(articalFragment: ArticalFragment)

    fun injectTo(indexFragment: IndexFragment)
}