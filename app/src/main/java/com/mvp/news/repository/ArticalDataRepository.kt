package com.mvp.news.repository

import com.mvp.comm.network.composessssss
import com.mvp.news.api.API
import com.mvp.news.modle.Artist
import retrofit2.http.Path
import rx.Observable
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/27 0027.
 */
class ArticalDataRepository : ArticalRepository {

    @Inject
    lateinit var ap: API

    override fun getArticalList(category: String, count: Int, page: Int): Observable<List<Artist>> =
        ap.getArticalList(category, count, page).composessssss()





}