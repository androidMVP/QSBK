package com.mvp.news.repository

import com.mvp.comm.network.Result
import com.mvp.news.modle.Artist
import rx.Observable

/**
 * Created by Administrator on 2018/3/27 0027.
 */
interface ArticalRepository {

    fun getArticalList(category: String, count: Int, page: Int): Observable<List<Artist>>

}
