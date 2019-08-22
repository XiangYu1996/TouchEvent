package com.example.testevent;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

public class TestDraw extends DrawerLayout {
    public TestDraw(@NonNull Context context) {
        super(context);
    }

    public TestDraw(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestDraw(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
