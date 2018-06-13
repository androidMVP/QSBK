package com.mvp.news.ui.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.mvp.news.R
import com.mvp.news.modle.Artist
import com.mvp.news.modle.ContentArtical
import com.mvp.news.modle.GithubProject

/**
 * Created by Administrator on 2017/11/16 0016.
 */
class QSBKArticalAdapter(layoutResId: Int, data: MutableList<Artist?>?) : BaseQuickAdapter<Artist?, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder?, item: Artist?) {


        helper?.getView<TextView>(R.id.tv_artical_content)?.text=item?.desc ?: "暂无描述"
        helper?.getView<TextView>(R.id.tv_artical_nickname)?.text = item?.who ?: "匿名"
        helper?.getView<TextView>(R.id.tv_artical_comment)?.text = item?.publishedAt

    }




}