package com.mvp.news.repository

import com.mvp.comm.network.Result
import com.mvp.news.api.API
import com.mvp.news.modle.Artist
import com.mvp.news.modle.Category
import io.reactivex.Observable
import java.util.ArrayList

/**
 * Created by Administrator on 2018/3/27 0027.
 */
interface ArticalRepository {

    fun getArticalList(category: String?, count: Int?, page: Int?): Observable<Result<List<Artist>>>

    fun getArticalCategory():ArrayList<Category>

}

