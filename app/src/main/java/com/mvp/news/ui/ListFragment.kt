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
import com.mvp.comm.base.BaseFragment
import com.mvp.comm.utils.waitDialog
import com.mvp.news.R
import com.mvp.news.ui.view.LoadDataView
import org.jetbrains.anko.find

/**
 * Created by Administrator on 2017/8/25 0025.
 */

abstract class ListFragment<T> : BaseFragment(), LoadDataView {

    var recycleView: RecyclerView? = null

    var adapter: BaseQuickAdapter<T, BaseViewHolder>? = null

    var datas: MutableList<T?> = ArrayList()

    var page: Int = 0


    override fun initData(savedInstanceState: Bundle?) {
        datas
        requestData()
    }

    override fun setListener() {
    }

    override fun initView() {
        adapter = getBaseQuickAdapter()
        adapter?.setStartUpFetchPosition(2)
        adapter?.setOnLoadMoreListener({
            adapter?.isUpFetching = true
            onLoadMoreRequested()
        }, recycleView)
        adapter?.loadMoreEnd(isLoadMoreEnable())
        recycleView = rootView?.find(R.id.fragmeng_list)
        recycleView?.layoutManager = LinearLayoutManager(activity as Context, LinearLayoutManager.VERTICAL, false)
        recycleView?.adapter = adapter



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_list, container, false)


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

    abstract fun loadMoreData()

    fun isCanRefresh(): Boolean {
        return true
    }

    fun isLoadMoreEnable(): Boolean {
        return true
    }

    open fun onLoadMoreRequested() {
        loadMoreData()
    }


    open fun upFetchDataSuccess(mutableList: List<T?>?) {
        datas.clear()
        page = 1
        adapter?.isUpFetching = false
        onRequstDataSuccess(mutableList)
    }

    open fun loadMoreRequestedSuccess(mutableList: List<T?>?) {
        onRequstDataSuccess(mutableList)
        adapter?.loadMoreComplete()
        page++
    }


    fun onRequstDataSuccess(mutableList: List<T?>?) {
        if (mutableList != null) {
            datas.addAll(mutableList)
        }
        adapter?.notifyDataSetChanged()
    }

    open fun onRequstDataError() {
        adapter?.isUpFetching = false
        adapter?.loadMoreComplete()
    }
}