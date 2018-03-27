package com.mvp.news.ui.activity

import android.os.Bundle
import android.widget.ImageView
import com.mvp.comm.base.BaseActivity
import com.mvp.news.R
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit


/**
 * Created by Administrator on 2017/11/15 0015.
 */
class SplashActivity : BaseActivity() {

    var image: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        image = find(R.id.im_splash_ad)
    }

    override fun initView() {
    }

    override fun initListener() {


    }

    override fun initData() {
        Observable
                .timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<Long>() {
                    override fun onError(e: Throwable?) {
                    }

                    override fun onNext(t: Long?) {
                    }

                    override fun onCompleted() {
                        startActivity<MainActivity>()
                    }
                })
    }

}