package com.mvp.news.ui.present

import com.mvp.comm.base.Presenter
import com.mvp.news.repository.ArticalRepository
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/27 0027.
 */
class ArticalPresent: Presenter {

    @Inject
    lateinit var articalDataRepository:ArticalRepository


    override fun pause() {
    }

    override fun destroy() {
    }

    override fun resume() {
    }

    fun requestArticalList(category: String, count: Int, page: Int){
        articalDataRepository.getArticalList("android",)
    }


}