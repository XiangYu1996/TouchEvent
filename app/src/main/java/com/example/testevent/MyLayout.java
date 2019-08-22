package com.example.testevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MyLayout extends LinearLayout {
    private final String TAG = "aaa";

    public MyLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {//分发
        Log.d(TAG, "MyLayout dispatchTouchEvent start:"+ ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {//拦截
        Log.d(TAG,"MyLayout onInterceptTouchEvent start:"+ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {//响应
        Log.d(TAG,"MyLayout onTouchEvent start:  ev.touchevevt");
        return super.onTouchEvent(event);
    }


}
