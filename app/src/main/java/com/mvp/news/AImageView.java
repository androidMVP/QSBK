package com.mvp.news;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/11/17 0017.
 */

public class AImageView extends ImageView {
    public AImageView(Context context) {
        super(context);
    }

    public AImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean flag = super.onTouchEvent(event);
        Log.i("AImageView onTouchEvent", String.valueOf(flag));
        return flag;
    }
}
