package com.example.baselibrary.base;


import android.os.Bundle;
import android.util.Log;

import com.example.baselibrary.entity.RequestEnum;
import com.example.baselibrary.entity.Result;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class BaseUrlActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }


    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEventbusReceiveDataFromUI(Result result){
        onReceiveDataFromUI(result.requestEnum,result.CODE,result.data,result.carryData);
        Log.e("error","onReceiveDataFromUI="+result.toString());
    }

    protected void onReceiveDataFromUI(RequestEnum requestEnum,int requestCode,Object... data){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
