package com.mvp.news.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.mvp.comm.base.BaseActivity
import com.mvp.news.R
import com.mvp.news.ui.widget.LoadingProgress
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

/**
 * @author MVP
 * created: 2018/6/15
 * desc:
 */
class WebViewActivity : BaseActivity() {

    lateinit var webView: WebView
    lateinit var loadingProgress: LoadingProgress

    var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
    }

    override fun initView() {
        webView = find(R.id.webview)
        loadingProgress = find(R.id.webview_loading)
    }

    override fun initListener() {
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun initData() {

        url = intent.getStringExtra("webUrl")
        if (url == null) {
            toast("链接不存在")
            return
        }
        val settings = webView.settings
        settings.javaScriptEnabled = true
        settings.useWideViewPort = true//将图片调整到适合webview的大小
        settings.loadWithOverviewMode = true// 缩放至屏幕的大小
        //其他细节操作
        settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK //关闭webview中缓存
        settings.allowFileAccess = true //设置可以访问文件
        settings.javaScriptCanOpenWindowsAutomatically = true //支持通过JS打开新窗口
        settings.loadsImagesAutomatically = true //支持自动加载图片
        settings.defaultTextEncodingName = "utf-8"//设置编码格式

        webView.loadUrl(url)

        webView.webViewClient = (object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        })
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (newProgress == 100) {
                    loadingProgress.visibility = View.GONE
                    return
                }
                loadingProgress.progress = newProgress
                loadingProgress.postInvalidate()

            }
        }
    }


}