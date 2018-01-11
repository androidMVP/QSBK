package com.mvp.news.modle

/**
 * Created by Administrator on 2017/8/22 0022.
 */

data class Android(val _id: String = "",
                   val createdAt: String = "",
                   val images: List<String>? = null,
                   val publishedAt: String = "",
                   val source: String = "",
                   val type: String = "",
                   val url: String = "",
                   val used: Boolean = false,
                   val who: String = ""
)
