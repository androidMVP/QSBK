package com.mvp.news.repository

import android.widget.TextView
import org.jetbrains.anko.enabled
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2017/9/22 0022.
 * 倒计时业务类
 */
class TimeBll {

    companion object {

        fun startMsgTime(tv: TextView?) {
            Observable
                    .interval(1, TimeUnit.SECONDS)
                    .take(60)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(object : Subscriber<Long>() {

                override fun onStart() {
                    tv?.enabled = false
                }

                override fun onError(e: Throwable?) {
                }

                override fun onNext(t: Long?) {
                    tv?.text = t.toString()
                }

                override fun onCompleted() {
                    tv?.text = "重新发送"
                    tv?.enabled = true
                }

            })
        }

    }


}