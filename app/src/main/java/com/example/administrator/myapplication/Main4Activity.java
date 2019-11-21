package com.example.administrator.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;



public class Main4Activity extends AppCompatActivity {
    private Button btn_test;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btn_test = findViewById(R.id.btn_test);

        btn_test.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                float viewX = v.getX();
                float movedX = event.getX();
                float finalX = viewX + movedX;

                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) btn_test.getLayoutParams();
                params.rightMargin += (int)(-movedX);
                btn_test.setLayoutParams(params);

                return true;
            }
        });
    }
}
