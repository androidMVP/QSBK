package com.mvp.news.api

import com.mvp.comm.network.Result
import com.mvp.commbusiness.bean.UserInfo
import com.mvp.news.modle.Artist
import com.mvp.news.modle.Category
import com.mvp.news.modle.MsgCodeResponse
import com.mvp.news.modle.RegistInfo
import retrofit2.http.*
import rx.Observable

/**
 * Created by Administrator on 2017/8/22 0022.
 */

interface API {

    @GET("category/getCategoryList")
    fun getArtical(): Observable<Result<List<Category>>>

    @GET("user/sendMsgCode")
    fun sendMsgCode(@Query("mobile") mobile: String?): Observable<Result<MsgCodeResponse>>

    @POST("user/regist")
    fun regist(@Body registInfo: RegistInfo): Observable<Result<UserInfo>>


    @GET("data/{category}/{count}/{page}")
    fun getArticalList(@Path("category") category: String, @Path("count") count: Int, @Path("page") page: Int): Observable<Result<List<Artist>>>

}