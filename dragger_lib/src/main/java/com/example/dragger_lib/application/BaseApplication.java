package com.example.dragger_lib.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.dragger_lib.dragger.component.AppComponent;
import com.example.dragger_lib.dragger.component.ComponentHolder;
import com.example.dragger_lib.dragger.component.DaggerAppComponent;
import com.example.dragger_lib.dragger.module.AppModule;

import javax.inject.Inject;

public class BaseApplication extends Application {

    @Inject
    SharedPreferences sp;

    @Override
    public void onCreate() {
        super.onCreate();


        AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
        ComponentHolder.setAppComponent(appComponent);

        Log.d("BaseApplication","sp="+sp);
    }
}
