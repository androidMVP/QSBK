package com.mvp.news.repository

import com.mvp.comm.base.BaseBll
import com.mvp.news.api.API
import com.mvp.news.modle.Category
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by Administrator on 2017/9/18 0018.
 */
class CategoryBll(val api: API) : BaseBll() {


    private val dataCategory = mutableListOf("Android", "iOS", "福利", "休息视频", "拓展资源", "前端")



}