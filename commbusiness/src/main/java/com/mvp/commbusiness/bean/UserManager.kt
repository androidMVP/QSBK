package com.mvp.commbusiness.bean

import com.mvp.comm.base.AppUtil
import com.mvp.comm.utils.JsonUtils
import com.mvp.comm.utils.SharePreferenceUtil

/**
 * Created by Administrator on 2017/9/22 0022.
 */
object UserManager {

    var userInfo: UserInfo? = null

    val key: String = "userInfo"

    fun save(userInfo: UserInfo?) {
        UserManager.userInfo = userInfo
        saveUserToSp(userInfo)
    }


    fun saveUserToSp(user: UserInfo?) {
        val jsonStr = JsonUtils.toJsonStr(user)//序列化
        SharePreferenceUtil.setValue(AppUtil.applicaion, key, jsonStr)//保存到本地
    }

    fun saveSpToUser() {
        val jsonStr = SharePreferenceUtil.getString(AppUtil.applicaion, key)//保存到本地
        userInfo = JsonUtils.fromJson(jsonStr, UserInfo::class.java)
    }
}