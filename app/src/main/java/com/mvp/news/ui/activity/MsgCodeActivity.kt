package com.mvp.news.ui.activity

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.mvp.comm.base.BaseActivity
import com.mvp.comm.utils.getColorssss
import com.mvp.comm.utils.getForegroundSpan
import com.mvp.commbusiness.bean.UserInfo
import com.mvp.news.App
import com.mvp.news.R
import com.mvp.news.di.subcomponent.user.UserModule
import com.mvp.news.modle.RegistInfo
import com.mvp.news.repository.TimeBll
import com.mvp.news.ui.present.MsgCodePresent
import com.mvp.news.ui.view.MsgCodeView
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by Administrator on 2017/9/20 0020.
 */
class MsgCodeActivity : BaseActivity(), MsgCodeView {


    var nextTv: TextView? = null
    var mobile: String? = null
    var moibieTv: TextView? = null
    var msgcodeEt: EditText? = null
    var psw: String? = null
    var timeTv: TextView? = null

    @Inject
    lateinit var prensent: MsgCodePresent




    override fun showMsg(msgCode: String) {


    }

    override fun showLoading() {
        dialog.show()
    }

    override fun hideLoading() {
        dialog.cancel()
    }

    override fun showError(code: Int, message: String) {
        toast(message)
    }

    override fun sendMsgSuccess() {
        toast("短信发送成功")
    }

    override fun registSuccess(userInfo: UserInfo) {
        startActivity<MainActivity>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_msg_code)
    }

    override fun initView() {
        App.graph.plus(UserModule(this)).injectTo(this)
        setTitle(getString(R.string.input_msg_code))
        setAppBarBg(getColorssss(R.color.color_white))
        moibieTv = find(R.id.tv_mobile_msgcode)
        nextTv = find(R.id.tv_next_msgcode)
        msgcodeEt = find(R.id.et_msg_msgcode)
        timeTv = find(R.id.tv_time_msgcode)
    }

    override fun initListener() {

        nextTv?.setOnClickListener {
            prensent.regist(RegistInfo(mobile = mobile, msgCode = msgcodeEt?.text.toString(), psassword = psw))
        }

        timeTv?.setOnClickListener {
            startMsgTime()
        }
    }


    override fun initData() {
        psw = intent.getStringExtra("psw")
        mobile = intent.getStringExtra("mobile")
        val content = String.format(getString(R.string.regist_send_msg_to), mobile)
        moibieTv?.text = getForegroundSpan(content, getColorssss(R.color.color_FFD744), 7, content.length)
        prensent.sendMsgCode(mobile = mobile)
    }

    private fun startMsgTime() {
        TimeBll.startMsgTime(timeTv)
    }


}