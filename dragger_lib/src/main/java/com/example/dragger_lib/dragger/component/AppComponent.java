package com.example.dragger_lib.dragger.component;

import android.content.SharedPreferences;

import com.example.dragger_lib.application.BaseApplication;
import com.example.dragger_lib.dragger.module.AppModule;

import dagger.Component;

@Component(modules =AppModule.class)
public interface AppComponent {


    BaseApplication provideApplication();

    SharedPreferences provideSharedPreferences();

    void inject(BaseApplication application);
}
