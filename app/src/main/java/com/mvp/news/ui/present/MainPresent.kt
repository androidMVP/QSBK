package com.mvp.news.ui.present

import com.mvp.comm.network.RxSubscribe
import com.mvp.news.modle.Category
import com.mvp.news.repository.CategoryBll
import com.mvp.news.ui.view.MainView

/**
 * Created by Administrator on 2017/8/25 0025.
 */
class MainPresent(val mainView: MainView, val categoryBll: CategoryBll) {


    fun reqeustCategoryList() {
        mainView.showLoading()
        categoryBll.getCategoryList().subscribe(object : RxSubscribe<List<Category>>() {
            override fun onSuccess(data: List<Category>) {
                mainView.hideLoading()
                mainView.showCategoryData(data)
            }

            override fun onError(code: Int, msg: String) {
                mainView.hideLoading()
                mainView.showError(code, msg)
            }

        })
    }


}