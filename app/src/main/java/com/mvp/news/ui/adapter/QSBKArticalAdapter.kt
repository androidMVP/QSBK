package com.mvp.news.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.mvp.news.modle.Artist
import com.mvp.news.modle.ContentArtical
import com.mvp.news.modle.GithubProject

/**
 * Created by Administrator on 2017/11/16 0016.
 */
class QSBKArticalAdapter(layoutResId: Int, data: MutableList<Artist?>?) : BaseQuickAdapter<Artist?, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder?, item: Artist?) {
    }


}