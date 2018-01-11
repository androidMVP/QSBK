package com.mvp.news.api

import com.mvp.comm.network.Result
import com.mvp.commbusiness.bean.UserInfo
import com.mvp.news.modle.Category
import com.mvp.news.modle.MsgCodeResponse
import com.mvp.news.modle.RegistInfo
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import rx.Observable

/**
 * Created by Administrator on 2017/8/22 0022.
 */

interface API {

    /*  @GET("Android/{data}/{index}")
      fun getAndroidData (@Path("data") groupId:Int,@Path("index") index:Int): Observable<Result<List<Android?>>>


      @GET("福利/{data}/{index}")
      fun getFuli(@Path("data") groupId:Int,@Path("index") index:Int): Observable<Result<List<Fuli?>>>




      @GET("github/list")
      fun getArtical(): Observable<Result<List<GithubProject>>>*/

    @GET("category/getCategoryList")
    fun getArtical(): Observable<Result<List<Category>>>

    @GET("user/sendMsgCode")
    fun sendMsgCode(@Query("mobile") mobile: String?): Observable<Result<MsgCodeResponse>>

    @POST("user/regist")
    fun regist(@Body registInfo: RegistInfo): Observable<Result<UserInfo>>

}