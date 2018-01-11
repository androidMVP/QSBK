package com.mvp.news.ui.present

import com.mvp.comm.action.RxAction
import com.mvp.comm.network.RxSubscribe
import com.mvp.commbusiness.bean.UserInfo
import com.mvp.news.modle.MsgCodeResponse
import com.mvp.news.modle.RegistInfo
import com.mvp.news.repository.UserBll
import com.mvp.news.ui.view.MsgCodeView

/**
 * Created by Administrator on 2017/9/21 0021.
 */
class MsgCodePresent(val userBll: UserBll, val msgCodeView: MsgCodeView) {


    fun sendMsgCode(mobile: String?) {
        userBll.sendMsgCode(mobile).subscribe(object : RxSubscribe<MsgCodeResponse>() {
            override fun onSuccess(data: MsgCodeResponse) {
                msgCodeView.sendMsgSuccess()
            }

            override fun onError(code: Int, msg: String) {
                msgCodeView.showError(code, msg)
            }

        })
    }

    fun regist(registInfo: RegistInfo) {
        msgCodeView.showLoading()
        userBll.regist(registInfo, object : RxAction<UserInfo> {
            override fun onSuccess(data: UserInfo) {
                msgCodeView.registSuccess(data)
                msgCodeView.hideLoading()
            }

            override fun onError(code: Int, msg: String) {
                msgCodeView.showError(code, msg)
                msgCodeView.hideLoading()
            }

        })
    }

}