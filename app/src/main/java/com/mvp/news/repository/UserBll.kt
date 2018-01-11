package com.mvp.news.repository

import com.mvp.comm.action.RxAction
import com.mvp.comm.network.BllException
import com.mvp.comm.network.RetCodeEnum
import com.mvp.comm.network.RxSubscribe
import com.mvp.comm.network.composessssss
import com.mvp.commbusiness.bean.UserInfo
import com.mvp.commbusiness.bean.UserManager
import com.mvp.news.api.API
import com.mvp.news.modle.MsgCodeResponse
import com.mvp.news.modle.RegistInfo
import rx.Observable

/**
 * Created by Administrator on 2017/9/20 0020.
 */
class UserBll(val api: API) {


    fun sendMsgCode(mobile: String?): Observable<MsgCodeResponse> {
        if (mobile.isNullOrEmpty()) {
            return Observable.error(BllException(RetCodeEnum.MOBILE_EMPTY))
        }
        return api.sendMsgCode(mobile).composessssss()
    }

    fun regist(registInfo: RegistInfo, rxAction: RxAction<UserInfo>) {
        if (registInfo.mobile.isNullOrEmpty()) {
            rxAction.onError(RetCodeEnum.MOBILE_EMPTY.code, RetCodeEnum.MOBILE_EMPTY.message)
        }
        if (registInfo.psassword.isNullOrEmpty()) {
            rxAction.onError(RetCodeEnum.PSW_EMPTY.code, RetCodeEnum.PSW_EMPTY.message)
        }

        if (registInfo.msgCode.isNullOrEmpty()) {
            rxAction.onError(RetCodeEnum.MSG_CODE_EMPTY.code, RetCodeEnum.MSG_CODE_EMPTY.message)
        }

        api.regist(registInfo)
                .composessssss()
                .subscribe(object : RxSubscribe<UserInfo>() {
                    override fun onSuccess(data: UserInfo) {
                        UserManager.save(data)
                        rxAction.onSuccess(data)
                    }

                    override fun onError(code: Int, msg: String) {
                        rxAction.onError(code, msg)
                    }
                })
    }

}