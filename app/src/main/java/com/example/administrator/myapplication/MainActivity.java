package com.example.administrator.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.baselibrary.Test;
import com.example.baselibrary.base.BaseUrlActivity;
import com.example.baselibrary.entity.RequestEnum;
import com.example.baselibrary.mvp.PresenterManager;
import com.example.baselibrary.test.A;

import butterknife.ButterKnife;

public class MainActivity extends BaseUrlActivity implements View.OnClickListener{

    Button tvTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Window var2 = this.getWindow();
        int var3 = var2.getDecorView().getSystemUiVisibility();
        var3 |= 1280;
        var2.getDecorView().setSystemUiVisibility(var3);
        var2.setStatusBarColor(0);


        tvTest=findViewById(R.id.tv_test);
        tvTest.setOnClickListener(this);


        PresenterManager.request(RequestEnum.VersionRequest1, "");
        PresenterManager.request(RequestEnum.VersionRequest2, "");
        PresenterManager.request(RequestEnum.VersionRequest1, "");
        PresenterManager.request(RequestEnum.VersionRequest2, "");

    }

    @Override
    protected void onReceiveDataFromUI(RequestEnum requestEnum, int requestCode, Object... data) {
        super.onReceiveDataFromUI(requestEnum, requestCode, data);
        Log.e("error", "---onReceiveDataFromUI----");
    }


    @Override
    public void onClick(View v) {
        try {
            Class cls = Class.forName(A.class.getName());
            Log.e("", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        new Test().test();
    }
}
