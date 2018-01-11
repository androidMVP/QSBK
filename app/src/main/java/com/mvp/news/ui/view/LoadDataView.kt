package com.mvp.news.ui.view

/**
 * Created by Administrator on 2017/8/25 0025.
 */
interface LoadDataView : PresentationView {

    fun showLoading()

    fun hideLoading()

    fun showError( code:Int,message: String)
}