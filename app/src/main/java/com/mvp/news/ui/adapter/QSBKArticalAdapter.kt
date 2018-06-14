package com.mvp.news.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.mvp.comm.utils.TimeUtils
import com.mvp.news.R
import com.mvp.news.modle.Artist
import java.text.DateFormat
import java.text.SimpleDateFormat

/**
 * Created by Administrator on 2017/11/16 0016.
 */
class QSBKArticalAdapter(layoutResId: Int, data: MutableList<Artist?>?) : BaseQuickAdapter<Artist?, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder?, item: Artist?) {


        helper?.getView<TextView>(R.id.tv_artical_content)?.text = item?.desc ?: "暂无描述"
        helper?.getView<TextView>(R.id.tv_artical_nickname)?.text = item?.who ?: "匿名"
        helper?.getView<TextView>(R.id.tv_artical_time)?.text = TimeUtils.date2String(TimeUtils.string2Date(item?.createdAt?.replace("Z"," UTC"), TimeUtils.DEFAULT_FORMAT2))
        //是否显示图片
        val articalImageView = helper?.getView<ImageView>(R.id.im_artical_img)
        if (item?.images?.size ?: -1 > 0) {
            articalImageView?.visibility = View.VISIBLE
            Glide.with(mContext).load(item?.images?.get(0)).into(articalImageView)
        } else {
            articalImageView?.visibility = View.GONE
        }

    }


}