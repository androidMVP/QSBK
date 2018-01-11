package com.mvp.news.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import com.mvp.comm.base.BaseActivity
import com.mvp.news.App
import com.mvp.news.R
import com.mvp.news.di.module.MainModule
import com.mvp.news.modle.Category
import com.mvp.news.ui.adapter.ListFragmentAdapter
import com.mvp.news.ui.fragment.ArticalFragment
import com.mvp.news.ui.present.MainPresent
import com.mvp.news.ui.view.MainView
import com.viewpagerindicator.TabPageIndicator
import org.jetbrains.anko.find
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {


    override fun showError(code: Int, message: String) {
    }

    lateinit var viewPage: ViewPager

    lateinit var titlepageindicator: TabPageIndicator

    lateinit var fragmentListAdapter: ListFragmentAdapter

    @Inject
    lateinit var mainPresent: MainPresent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initView() {
        App.graph.plus(MainModule(this)).injectTo(this)
        viewPage = find(R.id.viewpaeg_main)
        titlepageindicator = find(R.id.titlepageindicator_main)

        fragmentListAdapter = ListFragmentAdapter(mutableListOf(), mutableListOf(), supportFragmentManager)
        viewPage.adapter = fragmentListAdapter
        titlepageindicator.setViewPager(viewPage)
    }

    override fun initListener() {}

    override
    fun initData() {
        mainPresent.reqeustCategoryList()
    }


    override fun showLoading() {
        dialog.show()
    }

    override fun hideLoading() {
        dialog.dismiss()
    }


    override fun showCategoryData(data: List<Category>) {
        val fragmentLists = mutableListOf<Fragment>()
        val titleList = mutableListOf<String>()
        for (item in data) {
            fragmentLists.add(ArticalFragment.getFragment(item.title))
            titleList.add(item.title)
        }
        fragmentListAdapter.replaceData(titleList, fragmentLists)
        titlepageindicator.notifyDataSetChanged()
    }
}
