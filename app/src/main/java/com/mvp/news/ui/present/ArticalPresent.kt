package com.mvp.news.ui.present

import com.mvp.comm.base.Presenter
import com.mvp.news.domain.usercase.artical.GetArticalListTask
import com.mvp.news.modle.Artist
import com.mvp.news.repository.ArticalRepository
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/27 0027.
 */
class ArticalPresent @Inject constructor(private val articalListTask:GetArticalListTask): Presenter {




    override fun pause() {
    }

    override fun destroy() {
    }

    override fun resume() {
    }

    fun requestArticalList(category: String, count: Int, page: Int){
        articalListTask.execute( ArticalObserver(),GetArticalListTask.Params(null,10,1))
    }


    class ArticalObserver :DisposableObserver<List<Artist>>(){
        override fun onError(e: Throwable?) {
        }

        override fun onNext(artists: List<Artist>?) {
        }

        override fun onComplete() {
        }

    }


}