package com.mvp.news.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.mvp.news.R
import com.mvp.news.modle.ContentArtical
import com.mvp.news.ui.ListFragment
import com.mvp.news.ui.adapter.QSBKArticalAdapter
import com.mvp.news.ui.present.ArticalPresent
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by Administrator on 2017/8/25 0025.
 */
class ArticalFragment : ListFragment<ContentArtical?>() {

    @Inject
    lateinit var articalPresent: ArticalPresent


    override fun showError(code: Int, message: String) {
        activity?.toast(message)
    }


    override fun requestData() {
        val mutableListOf = mutableListOf<ContentArtical>()
     articalPresen.
        adapter?.replaceData(mutableListOf)

    }


    override fun getBaseQuickAdapter(): BaseQuickAdapter<ContentArtical?, BaseViewHolder>? {
        return QSBKArticalAdapter(R.layout.item_artical_list, mutableListOf())
    }


    companion object {
        fun getFragment(category: String): Fragment {
            val fragment = ArticalFragment()
            val bundle = Bundle()
            bundle.putString("category", category)
            fragment.arguments = bundle
            return fragment
        }
    }
}