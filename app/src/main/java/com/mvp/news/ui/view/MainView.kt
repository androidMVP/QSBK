package com.mvp.news.ui.view

import com.mvp.news.modle.Category


/**
 * Created by Administrator on 2017/8/25 0025.
 */
interface MainView : LoadDataView {

    fun showCategoryData(data:List<Category>)

}