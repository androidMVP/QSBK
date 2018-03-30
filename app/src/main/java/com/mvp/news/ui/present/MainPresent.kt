package com.mvp.news.ui.present

import com.mvp.comm.network.RxSubscribe
import com.mvp.commbusiness.bean.BusinessError
import com.mvp.news.modle.Category
import com.mvp.news.repository.CategoryBll
import com.mvp.news.ui.view.MainView
import org.jetbrains.annotations.NotNull
import rx.Subscriber

/**
 * Created by Administrator on 2017/8/25 0025.
 */
class MainPresent(val mainView: MainView, val categoryBll: CategoryBll) {



    fun reqeustCategoryList( ) {
        mainView.showLoading()
        categoryBll.getCategoryList().subscribe(object : Subscriber<List<Category>>() {
            override fun onCompleted() {
            }

            override fun onNext(data: List<Category>) {
                mainView.hideLoading()
                mainView.showCategoryData(data)
            }

            override fun onError(e: Throwable?) {
                mainView.hideLoading()
                mainView.showError(BusinessError.COMM_ERROR.code, BusinessError.COMM_ERROR.msg)
            }

        })

    }


}