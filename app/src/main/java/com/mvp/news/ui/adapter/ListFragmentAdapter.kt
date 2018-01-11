package com.mvp.news.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Administrator on 2017/8/25 0025.
 */
class ListFragmentAdapter(var titles: MutableList<String>?, var data: MutableList<Fragment>, fm: FragmentManager) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int) = data[position]

    override fun getCount() = data.size


    override fun getPageTitle(position: Int): CharSequence {
        if (titles?.isNotEmpty() ?: false)
            return titles?.get(position) ?: ""
        else
            return ""
    }

    fun replaceData(list1: List<String>, list2: MutableList<Fragment>) {
        titles?.clear()
        titles?.addAll(list1)
        data.clear()
        data.addAll(list2)
        notifyDataSetChanged()
    }

}