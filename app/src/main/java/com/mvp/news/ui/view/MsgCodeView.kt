package com.mvp.news.ui.view

import com.mvp.commbusiness.bean.UserInfo


/**
 * Created by Administrator on 2017/9/21 0021.
 */
interface MsgCodeView : LoadDataView {

    fun showMsg(msgCode: String)

    fun sendMsgSuccess()

    fun registSuccess(userInfo: UserInfo)


}