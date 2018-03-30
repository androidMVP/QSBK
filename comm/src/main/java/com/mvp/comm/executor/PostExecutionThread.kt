package com.mvp.comm.executor

import io.reactivex.Scheduler

/**
 * Created by Administrator on 2018/3/30 0030.
 */
interface PostExecutionThread {

    fun getScheduler(): Scheduler
}