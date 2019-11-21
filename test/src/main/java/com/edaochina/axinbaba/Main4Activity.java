package com.edaochina.axinbaba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.test.R;


public class Main4Activity extends AppCompatActivity {

    private ImageView iv_img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_4);

        iv_img1= (ImageView) findViewById(R.id.iv_img1);
        iv_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_img1.offsetTopAndBottom(100);
            }
        });

    }
}
