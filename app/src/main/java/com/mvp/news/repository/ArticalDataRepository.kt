package com.mvp.news.repository

import com.mvp.comm.network.composessssss
import com.mvp.news.api.API
import com.mvp.news.domain.usercase.artical.GetArticalListTask
import com.mvp.news.modle.Artist
import rx.Observable
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/27 0027.
 */
class ArticalDataRepository : ArticalRepository {

    @Inject
    lateinit var api: API

    override fun getArticalList(request: GetArticalListTask.RequestValues?): Observable<List<Artist>> =
            api.getArticalList(request?.category ?: "all", request?.count ?: 10, request?.page ?: 1).composessssss()


}