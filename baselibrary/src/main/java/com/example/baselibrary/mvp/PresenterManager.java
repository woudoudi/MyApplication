package com.example.baselibrary.mvp;

import com.example.baselibrary.entity.RequestEnum;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PresenterManager {


    public static void request(RequestEnum requestEnum,Object object){
        Observable.create(new CommonModel(requestEnum, object))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseView());
    }


    public static <T extends BaseModel> void request(T baseModel){
        Observable.create(baseModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseView());
    }
}
