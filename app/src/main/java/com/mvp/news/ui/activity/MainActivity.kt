package com.mvp.news.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.widget.RadioGroup
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

class MainActivity : BaseActivity() {

    var currentFragment: Fragment? = null

    lateinit var userInfoFragment: Fragment

    lateinit var indexFragment: Fragment

    lateinit var rgMain: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun initView() {
        rgMain = find(R.id.rg_main)
        inflaterFragment()
    }

    override fun initListener() {
        rgMain.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rb_index_main -> showFragment(indexFragment)
                R.id.rb_me_main -> showFragment(userInfoFragment)
            }
        }
    }

    override
    fun initData() {
    }

    /**
     * 填充fragment
     */
    fun inflaterFragment() {
        indexFragment = IndexFragment()

        userInfoFragment = MainUserInfoFragment()

        showFragment(indexFragment)
    }

    fun showFragment(fragment: Fragment?) {
        if (currentFragment != fragment) {
            val beginTransaction = supportFragmentManager.beginTransaction()
            if(currentFragment!=null)
            beginTransaction.hide(currentFragment)
            currentFragment = fragment
            if (fragment?.isAdded!!) {
                beginTransaction.add(R.id.fl_main, fragment).commit()
            } else {
                beginTransaction.show(fragment).commit()
            }

        }

    }


}
