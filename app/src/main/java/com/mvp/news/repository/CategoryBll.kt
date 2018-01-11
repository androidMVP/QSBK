package com.mvp.news.repository

import com.mvp.comm.base.BaseBll
import com.mvp.comm.network.composessssss
import com.mvp.news.api.API

/**
 * Created by Administrator on 2017/9/18 0018.
 */
class CategoryBll(val api: API) : BaseBll() {


    fun getCategoryList() =
            api.getArtical().composessssss()
}