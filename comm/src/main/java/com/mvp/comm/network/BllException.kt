package com.mvp.comm.network

/**
 * Created by Administrator on 2017/8/25 0025.
 */
class BllException(var code: Int, var msg: String) : RuntimeException() {

    constructor(enum: RetCodeEnum) : this(enum.code, enum.message)

}