package com.mvp.news.ui.present

import com.mvp.news.modle.Category
import com.mvp.news.ui.view.MainView

/**
 * Created by Administrator on 2017/8/25 0025.
 */
class MainPresent(val mainView: MainView) {



    fun reqeustCategoryList( ) {


        mainView.showCategoryData( mutableListOf<Category>(Category("ios")))
//        categoryBll.getCategoryList().subscribe(object : Subscriber<List<Category>>() {
//            override fun onCompleted() {
//            }
//
//            override fun onNext(data: List<Category>) {
//                mainView.hideLoading()
//                mainView.showCategoryData(data)
//            }
//
//            override fun onError(e: Throwable?) {
//                mainView.hideLoading()
//                mainView.showError(BusinessError.COMM_ERROR.code, BusinessError.COMM_ERROR.msg)
//            }
//
//        })

    }


}