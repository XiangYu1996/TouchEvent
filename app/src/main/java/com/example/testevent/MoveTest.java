package com.example.testevent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MoveTest extends AppCompatActivity implements View.OnTouchListener,View.OnClickListener, View.OnLongClickListener {

    private ImageView iv_dv_view;
    private int sx;
    private int sy;
    private SharedPreferences sp;
    private int dx;
    private int dy;
    private Timer timer;
    private boolean isLongClickModule;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movetest);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        sp = this.getSharedPreferences("config", Context.MODE_PRIVATE);
        iv_dv_view = (ImageView) this.findViewById(R.id.move_img);
        sp = this.getSharedPreferences("config", Context.MODE_PRIVATE);
        iv_dv_view.setOnTouchListener(this);
        iv_dv_view.setOnClickListener(this);
        iv_dv_view.setOnLongClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()) {
                // 如果手指放在imageView上拖动
                case R.id.move_img:
                    // event.getRawX(); //获取手指第一次接触屏幕在x方向的坐标
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:// 获取手指第一次接触屏幕
                            sx = (int) event.getRawX();
                            sy = (int) event.getRawY();
                            iv_dv_view.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                            break;
                        case MotionEvent.ACTION_MOVE:// 手指在屏幕上移动对应的事件

                                int x = (int) event.getRawX();
                                int y = (int) event.getRawY();
                                // 获取手指移动的距离
                                dx = x - sx;
                                dy = y - sy;
                                // 得到imageView最开始的各顶点的坐标
                                int l = iv_dv_view.getLeft();
                                int r = iv_dv_view.getRight();
                                int t = iv_dv_view.getTop();
                                int b = iv_dv_view.getBottom();
                                // 更改imageView在窗体的位置
                                iv_dv_view.layout(l + dx, t + dy, r + dx, b + dy);
                                // 获取移动后的位置
                                sx = (int) event.getRawX();
                                sy = (int) event.getRawY();
                            break;
                        case MotionEvent.ACTION_UP:// 手指离开屏幕对应事件

                            int lastsx = (int) event.getRawX();
                            int lastsy = (int) event.getRawY();

                            // 记录最后图片在窗体的位置
                            int lasty = iv_dv_view.getTop();
                            int lastx = iv_dv_view.getLeft();
                            iv_dv_view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putInt("lasty", lasty);
                            editor.putInt("lastx", lastx);
                            editor.commit();
                            if (Math.abs(lastsx - sx) < 1 && Math.abs(lastsy - sy) < 1) {
                                v.performClick();
                            }
                            break;
                    }
                    break;
            }

        return true;// 不会中断触摸事件的返回
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "onClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(this, "longPress11111111111", Toast.LENGTH_SHORT).show();
        return true;
    }
}
