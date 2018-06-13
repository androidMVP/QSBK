package com.mvp.comm.base

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

/**
 * Created by Administrator on 2017/8/25 0025.
 */
abstract class BaseFragment : Fragment() {

     var rootView: View? = null

    var activity: Activity? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rootView = view
        activity = getActivity()
        initView()
        setListener()
        initData(savedInstanceState)
        super.onViewCreated(view, savedInstanceState)
    }
    abstract fun initData(savedInstanceState: Bundle?)

    abstract fun setListener()

    abstract fun initView()
}