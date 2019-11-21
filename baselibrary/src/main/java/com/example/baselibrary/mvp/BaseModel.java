package com.example.baselibrary.mvp;

import com.example.baselibrary.entity.RequestEnum;
import com.example.baselibrary.entity.Result;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public abstract class BaseModel implements ObservableOnSubscribe<Object> {
    protected RequestEnum requestEnum;
    protected Object object;

    public BaseModel(RequestEnum requestEnum, Object... object) {
        this.requestEnum = requestEnum;
        this.object = object;
    }

    public abstract Result request();

    @Override
    public void subscribe(ObservableEmitter<Object> e) throws Exception {
        Result result = request();
        result.requestEnum = requestEnum;
        e.onNext(result);
        e.onComplete();
    }
}
