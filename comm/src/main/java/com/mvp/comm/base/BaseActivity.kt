package com.mvp.comm.base

import android.app.ProgressDialog
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import com.mvp.comm.R
import com.mvp.comm.utils.waitDialog
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.find


/**
 * Created by Administrator on 2017/8/23 0023.
 */
abstract class BaseActivity : AppCompatActivity() {

    var title: TextView? = null
    var appbar: AppBarLayout? = null

    val dialog: ProgressDialog by lazy {
        waitDialog(false, message = "等等我…", title = null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSystemBarTransparent()
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        val mToolbar = findViewById<Toolbar>(R.id.toolbar)
        if (mToolbar != null) {
            appbar = find(R.id.appbar)
            title = find(R.id.title)
            setSupportActionBar(mToolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        initView()
        initListener()
        initData()
    }

    abstract fun initView()

    abstract fun initListener()

    abstract fun initData()

    fun setTitle(content: String) {
        title?.text = content
    }

    fun setAppBarBg(color: Int) {
        appbar?.backgroundColor = color
    }


    fun setSystemBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // LOLLIPOP解决方案
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // KITKAT解决方案
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }

}
