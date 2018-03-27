package com.mvp.news.ui

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.mvp.comm.utils.waitDialog
import com.mvp.comm.base.BaseFragment
import com.mvp.news.R
import com.mvp.news.ui.view.LoadDataView
import org.jetbrains.anko.find

/**
 * Created by Administrator on 2017/8/25 0025.
 */

abstract class ListFragment<T> : BaseFragment(), LoadDataView {

    var recycleView: RecyclerView? = null

    var adapter: BaseQuickAdapter<T, BaseViewHolder>? = null

    override fun initData(savedInstanceState: Bundle?) {
        requestData()
    }

    override fun setListener() {
    }

    override fun initView() {
        adapter = getBaseQuickAdapter()
        recycleView = rootView?.find(R.id.fragmeng_list)
        recycleView?.layoutManager = LinearLayoutManager(activity as Context, LinearLayoutManager.VERTICAL, false)
        recycleView?.adapter = adapter

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater?.inflate(R.layout.fragment_list, container, false)


    val dialog: ProgressDialog? by lazy {
        activity?.waitDialog(false, message = "等等我…", title = null)
    }


    override fun showLoading() {
        dialog?.show()
    }

    override fun hideLoading() {
        dialog?.hide()
    }



    abstract fun getBaseQuickAdapter(): BaseQuickAdapter<T, BaseViewHolder>?

    abstract fun requestData()


}