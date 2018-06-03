package com.mvp.news.repository

import com.mvp.comm.network.Result
import com.mvp.news.api.API
import com.mvp.news.modle.Artist
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/27 0027.
 */
class ArticalDataRepository constructor(val api: API): ArticalRepository {

    override fun getArticalList(category: String?, count: Int?, page: Int?): Observable<Result<List<Artist>>> {
        return api.getArticalList(category, count, page)
    }


}