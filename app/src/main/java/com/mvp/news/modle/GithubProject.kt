package com.mvp.news.modle

/**
 * Created by Administrator on 2017/8/30 0030.
 */
data class GithubProject(val id: Int,
                         val title: String,
                         val image: String,
                         val githubUrl: String,
                         val createTime: String,
                         val authorName: String,
                         val authorAvatar: String,
                         val githubDesc: String)