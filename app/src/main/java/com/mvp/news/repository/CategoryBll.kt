package com.mvp.news.repository

import com.mvp.comm.base.BaseBll
import com.mvp.comm.network.composessssss
import com.mvp.news.api.API
import com.mvp.news.modle.Category
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Func1
import rx.schedulers.Schedulers
import java.util.*

/**
 * Created by Administrator on 2017/9/18 0018.
 */
class CategoryBll(val api: API) : BaseBll() {


    private val dataCategory = mutableListOf("Android", "iOS", "福利", "休息视频", "拓展资源", "前端")

    fun getCategoryList(): Observable<List<Category>> {
        return Observable.from(dataCategory).map { item -> Category(item) }
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
    }


}