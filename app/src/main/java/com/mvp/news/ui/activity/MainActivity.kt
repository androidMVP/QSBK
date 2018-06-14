package com.mvp.news.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.RadioGroup
import com.mvp.comm.base.BaseActivity
import com.mvp.news.R
import com.mvp.news.ui.fragment.IndexFragment
import com.mvp.news.ui.fragment.MainUserInfoFragment
import org.jetbrains.anko.find

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
        rgMain.setOnCheckedChangeListener { _, checkedId ->
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
        if (currentFragment == null) {
            currentFragment = fragment
            supportFragmentManager.beginTransaction().add(R.id.fl_main, fragment).commit()
        } else {
            if (currentFragment !== fragment) {
                val beginTransaction = supportFragmentManager.beginTransaction()
                beginTransaction.hide(currentFragment)
                currentFragment = fragment
                if (fragment?.isAdded == true) {
                    beginTransaction.add(R.id.fl_main, fragment).commit()
                } else {
                    beginTransaction.show(fragment).commit()
                }

            }
        }


    }


}
