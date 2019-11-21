package com.example.administrator.myapplication.utils;

import java.lang.annotation.Annotation;

public class Person implements Test{

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
