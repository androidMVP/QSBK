package com.mvp.news.ui.activity

import android.os.Bundle
import android.widget.ImageView
import com.mvp.comm.base.BaseActivity
import com.mvp.news.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.reactivestreams.Subscriber
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
                .subscribe(object : Observer<Long> {
                    override fun onNext(value: Long?) {
                    }

                    override fun onComplete() {
                        startActivity<MainActivity>()
                    }

                    override fun onError(e: Throwable?) {
                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                })
    }

}