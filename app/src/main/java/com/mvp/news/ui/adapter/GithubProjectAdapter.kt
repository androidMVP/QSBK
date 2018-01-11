package com.mvp.news.ui.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.mvp.news.R
import com.mvp.news.modle.GithubProject


/**
 * Created by Administrator on 2017/8/22 0022.
 */
class GithubProjectAdapter(layoutResId: Int, data: MutableList<GithubProject?>?) : BaseQuickAdapter<GithubProject?, BaseViewHolder>(layoutResId, data) {


    override fun convert(helper: BaseViewHolder?, item: GithubProject?) {
        helper?.setText(R.id.tv_github_title, item?.title)
        helper?.setText(R.id.tv_github_desc, item?.githubDesc)
        helper?.setText(R.id.tv_github_time, item?.createTime)
        helper?.setText(R.id.tv_github_author, item?.authorName)
        val articalImg = item?.image ?: ""
        if (!articalImg.endsWith(".gif")) {
            Glide.with(mContext).load(articalImg).into(helper?.getView(R.id.im_github))
        } else {
            Glide.with(mContext).load(articalImg).asGif().into(helper?.getView(R.id.im_github))
        }
        Glide.with(mContext).load(item?.authorAvatar).into(helper?.getView(R.id.im_github_avatar))
    }


}

