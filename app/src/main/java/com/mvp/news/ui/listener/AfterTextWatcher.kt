package com.mvp.news.ui.listener

import android.text.Editable
import android.text.TextWatcher

/**
 * Created by Administrator on 2017/9/20 0020.
 */
abstract class AfterTextWatcher:TextWatcher{
    override fun afterTextChanged(p0: Editable?) {
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }
}