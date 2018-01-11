package com.mvp.comm.utils

import android.app.ProgressDialog
import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan

/**
 * Created by Administrator on 2017/8/25 0025.
 */
fun Context.waitDialog(
        indeterminate: Boolean,
        message: String? = null,
        title: String? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = ProgressDialog(this).apply {
    isIndeterminate = indeterminate
    if (!indeterminate) setProgressStyle(ProgressDialog.STYLE_SPINNER)
    if (message != null) setMessage(message)
    if (title != null) setTitle(title)
    if (init != null) init()
    show()
}

fun Context.getColorssss(color: Int) = resources.getColor(color)

fun Context.getForegroundSpan(content: String, textColor: Int, start: Int, end: Int): SpannableString {
    val spannableString = SpannableString(content)
    val colorSpan = ForegroundColorSpan(textColor)
    spannableString.setSpan(colorSpan, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
    return spannableString
}


