package com.example.dragger_lib.dragger.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.dragger_lib.MainActivity;
import com.example.dragger_lib.dragger.anotation.ActivityScope;
import com.example.dragger_lib.mvp.view.ICommonView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private ICommonView iView;
    private MainActivity mActivity;

    public ActivityModule(ICommonView iView){
        this.iView = iView;
        this.mActivity = (MainActivity) iView;
    }

    @Provides
    public ICommonView provideIcommonView(){
        return this.iView;
    }


    @Provides
    public SharedPreferences getSharePreferences(){
        return mActivity.getSharedPreferences("spfile", Context.MODE_PRIVATE);
    }

}
