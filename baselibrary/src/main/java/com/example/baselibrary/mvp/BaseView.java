package com.example.baselibrary.mvp;

import com.example.baselibrary.entity.Result;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.functions.Consumer;


public class BaseView implements Consumer<Object> {


    @Override
    public void accept(Object result) throws Exception {
        EventBus.getDefault().post(result);
    }
}
