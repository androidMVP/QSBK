package com.mvp.news.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mvp.comm.base.BaseFragment
import com.mvp.news.App
import com.mvp.news.R
import com.mvp.news.di.subcomponent.main.MainModule
import com.mvp.news.domain.usercase.artical.GetArticalCategoryTask
import com.mvp.news.modle.Category
import com.mvp.news.ui.adapter.ListFragmentAdapter
import com.mvp.news.ui.present.MainPresent
import com.mvp.news.ui.view.MainView
import com.viewpagerindicator.TabPageIndicator
import org.jetbrains.anko.find
import javax.inject.Inject

/**
 * Created by Administrator on 2018/1/11 0011.
 */
class IndexFragment : BaseFragment(), MainView {


    override fun showError(code: Int, message: String) {
    }

    var viewPage: ViewPager? = null

    var titlepageindicator: TabPageIndicator? = null

    lateinit var fragmentListAdapter: ListFragmentAdapter

    @Inject
    lateinit var mainPresent: MainPresent




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_index, container, false)
    }

    override fun initData(savedInstanceState: Bundle?) {
        val categoryList = mainPresent.reqeustCategoryList()
        showCategoryData(categoryList)
    }

    override fun setListener() {
    }

    override fun initView() {
        App.graph.plus(MainModule(this)).injectTo(this)
        viewPage = rootView?.find(R.id.viewpaeg_main)
        titlepageindicator = rootView?.find(R.id.titlepageindicator_main)

        fragmentListAdapter = ListFragmentAdapter(mutableListOf(), mutableListOf(), childFragmentManager)
        viewPage?.adapter = fragmentListAdapter
        titlepageindicator?.setViewPager(viewPage)

    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }


    override fun showCategoryData(data: List<Category>) {
        val fragmentLists = mutableListOf<Fragment>()
        val titleList = mutableListOf<String>()
        for (item in data) {
            fragmentLists.add(ArticalFragment.getFragment(item.title))
            titleList.add(item.title)
        }
        fragmentListAdapter.replaceData(titleList, fragmentLists)
        titlepageindicator?.notifyDataSetChanged()
    }


}