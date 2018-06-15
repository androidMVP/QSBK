package com.mvp.news.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.mvp.news.App
import com.mvp.news.R
import com.mvp.news.di.subcomponent.artical.ArticalModule
import com.mvp.news.modle.Artist
import com.mvp.news.ui.ListFragment
import com.mvp.news.ui.activity.WebViewActivity
import com.mvp.news.ui.adapter.QSBKArticalAdapter
import com.mvp.news.ui.present.ArticalPresent
import com.mvp.news.ui.view.ArticalView
import org.jetbrains.anko.toast
import org.jetbrains.anko.startActivity
import javax.inject.Inject

/**
 * Created by Administrator on 2017/8/25 0025.
 */
class ArticalFragment : ListFragment<Artist?>(), ArticalView {


    @Inject
    lateinit var articalPresent: ArticalPresent

    var category: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        category = arguments?.getString("category")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initView() {
        super.initView()
        App.graph.plus(ArticalModule(this)).injectTo(this)
    }

    override fun setListener() {
        super.setListener()
        adapter?.onItemClickListener = BaseQuickAdapter.OnItemClickListener { _, view, position ->
            if (datas[position]?.url != null)
                activity?.startActivity<WebViewActivity>("webUrl" to datas[position]?.url)
        }
    }


    override fun showArticalData(datas: List<Artist?>) {
        upFetchDataSuccess(datas)
    }

    override fun loadMoreArticalData(datas: List<Artist?>) {
        loadMoreRequestedSuccess(datas)
    }


    override fun showError(code: Int, message: String) {
        activity?.toast(message)
    }


    override fun requestData() {
        articalPresent.requestArticalList(category ?: "Android", 10, 1)
    }

    override fun loadMoreData() {
        articalPresent.loadMoreArticalList(category ?: "Android", 10, page)
    }

    override fun getBaseQuickAdapter(): BaseQuickAdapter<Artist?, BaseViewHolder>? {
        return QSBKArticalAdapter(R.layout.item_artical_list, datas)
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