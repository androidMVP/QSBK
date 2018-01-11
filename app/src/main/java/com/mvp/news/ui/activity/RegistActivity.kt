package com.mvp.news.ui.activity

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.mvp.comm.utils.getColorssss
import com.mvp.comm.base.BaseActivity
import com.mvp.news.R
import com.mvp.news.ui.listener.AfterTextWatcher
import org.jetbrains.anko.enabled
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by Administrator on 2017/9/19 0019.
 */
class RegistActivity : BaseActivity() {

    var registTv: TextView? = null
    var registMobileEt: EditText? = null
    var registPswEt: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)

    }

    override fun initView() {

        registTv = find(R.id.tv_regist)
        registMobileEt = find(R.id.et_mobile_reigst)
        registPswEt = find(R.id.et_psw_reigst)

        setTitle(getString(R.string.regist_account))
        setAppBarBg(getColorssss(R.color.color_white))
    }

    override fun initListener() {
        registTv?.setOnClickListener {
            startMsgCodeActivity()
        }

        registMobileEt?.addTextChangedListener(object : AfterTextWatcher() {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                registTv?.enabled = registMobileEt?.text?.isNotEmpty()!! and registPswEt?.text?.isNotEmpty()!!
            }
        })

        registPswEt?.addTextChangedListener(object : AfterTextWatcher() {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                registTv?.enabled = registMobileEt?.text?.isNotEmpty()!! and registPswEt?.text?.isNotEmpty()!!
            }
        })

    }

    override fun initData() {
    }


    private fun startMsgCodeActivity() {

        val mobile = registMobileEt?.text.toString()
        val psw = registPswEt?.text.toString()

        if (mobile.isEmpty()!!) {
            toast(R.string.error_mobile_not_empty)
            return
        }

        if (psw.isEmpty()!!) {
            toast(R.string.error_psw_not_empty)
            return
        }

        startActivity<MsgCodeActivity>("mobile" to mobile, "psw" to psw)
    }

}