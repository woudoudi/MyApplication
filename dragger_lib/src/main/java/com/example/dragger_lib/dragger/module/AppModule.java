package com.example.dragger_lib.dragger.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.dragger_lib.application.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private BaseApplication application;

    public AppModule(BaseApplication application) {
        this.application = application;
    }

        //提供全局的sp对象
    @Provides
    SharedPreferences provideSharedPreferences(){
         return application.getSharedPreferences("spfile", Context.MODE_PRIVATE);
    }

        //提供全局的Application对象
     @Provides
     BaseApplication provideApplication(){
         return application;
     }
}
