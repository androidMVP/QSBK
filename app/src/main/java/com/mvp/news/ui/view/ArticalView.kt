package com.mvp.news.ui.view

import com.mvp.news.modle.Artist

/**
 * @author MVP
 * created: 2018/6/5
 * desc:
 */
interface ArticalView : LoadDataView {

    fun showArticalData(datas:List<Artist?>)

    fun loadMoreArticalData(datas:List<Artist?>)
}