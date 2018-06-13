package com.mvp.news.ui.present

import android.widget.Toast
import com.mvp.comm.base.Presenter
import com.mvp.comm.network.RxSubscribe
import com.mvp.news.domain.usercase.artical.GetArticalListTask
import com.mvp.news.modle.Artist
import com.mvp.news.repository.ArticalRepository
import com.mvp.news.ui.view.ArticalView
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/27 0027.
 */
class ArticalPresent @Inject constructor(var articalView: ArticalView, val articalListTask: GetArticalListTask) : Presenter {


    override fun pause() {
    }

    override fun destroy() {
    }

    override fun resume() {
    }

    fun requestArticalList(category: String, count: Int, page: Int) {
        articalListTask.execute(ArticalObserver(), GetArticalListTask.Params(category, count, page))
    }

    fun loadMoreArticalList(category: String, count: Int, page: Int) {
        articalListTask.execute(LoadMoreArticalObserver(), GetArticalListTask.Params(category, count, page))
    }


    inner class ArticalObserver : RxSubscribe<List<Artist?>>() {
        override fun onSuccess(data: List<Artist?>) {
            articalView.showArticalData(data)
        }

        override fun onError(code: Int, msg: String) {
            articalView.showError(code, msg)
        }

    }

    inner class LoadMoreArticalObserver : RxSubscribe<List<Artist?>>() {
        override fun onSuccess(data: List<Artist?>) {
            articalView.loadMoreArticalData(data)
        }

        override fun onError(code: Int, msg: String) {
            articalView.showError(code, msg)
        }

    }



}