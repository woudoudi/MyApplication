package com.example.dragger_lib.entity;

import com.example.dragger_lib.mvp.model.User;

import javax.inject.Inject;

public class Student {

    private User mUser;

    @Inject
    public Student(User user){
        mUser = user;
    }

    public User getUser(){
        return mUser;
    }
}
