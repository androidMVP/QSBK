package com.mvp.comm.network

/**
 * Created by Administrator on 2017/8/25 0025.
 *
 * 用户注册错误：610~710
 *
 */


enum class RetCodeEnum(val code: Int, val message: String) {
    SYS_ERROR(-1, "网络服务异常，请稍后再试"),
    APP_ERROR(-2, "无法访问服务，请稍后重试"),
    NET_WORK_ERROR(110, "无法连接到网络，请检查网络再重试"),
    MOBILE_EMPTY(610, "手机号为空"),
    PSW_EMPTY(611, "密码为空"),
    MSG_CODE_EMPTY(612, "注册验证码为空");
}