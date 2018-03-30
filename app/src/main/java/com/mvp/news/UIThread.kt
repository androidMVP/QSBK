package com.mvp.news

import com.mvp.comm.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Administrator on 2018/3/30 0030.
 */
@Singleton
class UIThread @Inject constructor() : PostExecutionThread {
    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

}