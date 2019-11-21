package com.example.dragger_lib.dragger.component;

import com.example.dragger_lib.MainActivity;
import com.example.dragger_lib.dragger.module.ActivityModule;

import javax.inject.Singleton;

import dagger.Component;


@Component(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
