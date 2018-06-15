package com.mvp.news.ui.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @author MVP
 * created: 2018/6/15
 * desc:
 */
class LoadingProgress : View {

    var progress: Int = 0

    val mPaint = Paint()

    constructor(context: Context) : this(context, null)


    constructor(context: Context, atts: AttributeSet?) : this(context, atts, 0)


    constructor(context: Context, atts: AttributeSet?, defStyleAttr: Int) : super(context, atts, defStyleAttr) {
        init()
    }

    private fun init() {
        mPaint.strokeWidth = 5f
        mPaint.color = Color.parseColor("#0000ff")//颜色待设置
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(0f, 0f, (width * progress / 100).toFloat(), 0f, mPaint)
    }
}
