package com.example.dragger_lib.mvp.model;

import java.io.Serializable;

import javax.inject.Inject;

//model 类
public class User implements Serializable {

    @Inject
    public User(){
    }

    private int id;
    private String userName;
    private String pwd;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
