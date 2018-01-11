package com.mvp.news;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/11/17 0017.
 */

public class BButton extends Button {
    public BButton(Context context) {
        super(context);
    }

    public BButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean flag = super.onTouchEvent(event);
        Log.i("Button onTouchEvent", String.valueOf(flag));
        return flag;
    }
}
