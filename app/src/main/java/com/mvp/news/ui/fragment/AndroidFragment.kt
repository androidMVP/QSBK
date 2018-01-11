package com.mvp.news.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.mvp.news.App
import com.mvp.news.R
import com.mvp.news.di.module.MainModule
import com.mvp.news.modle.Android
import com.mvp.news.modle.Category
import com.mvp.news.ui.ListFragment
import com.mvp.news.ui.adapter.AndroidListAdapter
import com.mvp.news.ui.present.MainPresent
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by Administrator on 2017/8/25 0025.
 */
class AndroidFragment : ListFragment<Android?>() {



    @Inject
    lateinit var mainPresent: MainPresent

    override fun showError(code: Int, message: String) {
        activity?.toast(message)
    }


    override fun initView() {
        super.initView()
        App.graph.plus(MainModule(this)).injectTo(this)
    }


    override fun showCategoryData(data: List<Category>) {
    }
    override fun requestData() {
//        mainPresent.requestArtical()
    }


    override fun getBaseQuickAdapter(): BaseQuickAdapter<Android?, BaseViewHolder>? {
        return AndroidListAdapter(R.layout.layout_main_list, null)
    }


    companion object {
        fun getFragment(category: String): Fragment {
            val fragment = AndroidFragment()
            val bundle = Bundle()
            bundle.putString("category", category)
            fragment.arguments = bundle
            return fragment
        }
    }
}