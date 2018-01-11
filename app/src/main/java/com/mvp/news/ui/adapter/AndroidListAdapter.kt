package com.mvp.news.ui.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.mvp.news.R
import com.mvp.news.modle.Android


/**
 * Created by Administrator on 2017/8/22 0022.
 */
class AndroidListAdapter(layoutResId:Int,data: MutableList<Android?>?) : BaseQuickAdapter<Android?, BaseViewHolder>(layoutResId,data) {


    override fun convert(helper: BaseViewHolder?, item: Android?) {
        helper?.setText(R.id.tv_androi_title, item?.url ?: "此处无连接")
        Glide.with(mContext).load("https://ws1.sinaimg.cn/large/610dc034ly1fiuiw5givwj20u011h79a.jpg").into(helper?.getView(R.id.im_android))
    }
}

