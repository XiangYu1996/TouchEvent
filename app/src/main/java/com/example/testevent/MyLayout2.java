package com.example.testevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MyLayout2 extends LinearLayout {
    private final String TAG = "aaa";

    public MyLayout2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {//分发
        Log.d(TAG, "MyLayout2 dispatchTouchEvent: " +ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {//拦截
        getParent().requestDisallowInterceptTouchEvent(true);
        Log.d(TAG, "MyLayout2 onInterceptTouchEvent: " +ev.getAction());
      return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {//响应
        Log.d(TAG, "MyLayout2 onInterceptTouchEvent: " +event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }
}
