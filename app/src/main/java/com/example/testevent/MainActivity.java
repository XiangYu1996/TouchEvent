package com.example.testevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "aaa";

    private int lastX;
    private int lastY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyLayout myLayout = findViewById(R.id.mylayout);
        final MyLayout2 myLayout2 = findViewById(R.id.mylayout2);
        MyButton myButton = findViewById(R.id.mybutton);

        myLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "MyLayout11111", Toast.LENGTH_SHORT).show();
            }
        });
        myLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "MyLayout22222", Toast.LENGTH_SHORT).show();
            }
        });
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MoveTest.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "MyButton", Toast.LENGTH_SHORT).show();
            }
        });

        myLayout2.setOnTouchListener(myLayout2TouchListener(myLayout2));
    }

    private View.OnTouchListener myLayout2TouchListener(final MyLayout2 myLayout2) {
        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // 记录触摸点坐标
                        lastX = x;
                        lastY = y;
                        break;
                    case MotionEvent.ACTION_UP:
                        // 计算偏移量
                        int offsetX = Math.abs(x - lastX);
                        int offsetY = Math.abs(y - lastY);
                        if (offsetX > 5 || offsetY>5){
                            Toast.makeText(MainActivity.this, "myLayout22222滑动", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "myLayout2  onTouch:  滑动");
                        } else {
                            //这句代码：做myLayout.setOnClickListener中的点击事件，在自定义中performClick()也要重写
                            myLayout2.performClick();
//                            Toast.makeText(MainActivity.this, "myLayout22222点击", Toast.LENGTH_SHORT).show();
//                            Log.d(TAG, "myLayout2  onTouch:  点击");
                        }
                        break;
                }
                return true;
            }
        };
    }
}
