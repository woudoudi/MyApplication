package com.example.baselibrary.entity;

public class Result {

    public static int SUCCESS_CODE=1;
    public static int FAIL_CODE=-1;

    public int CODE = FAIL_CODE;

    public RequestEnum requestEnum;

    public Object data;

    public Object carryData;

    @Override
    public String toString() {
        return "Result{" +
                "CODE=" + CODE +
                ", requestEnum=" + requestEnum +
                ", data=" + data +
                ", carryData=" + carryData +
                '}';
    }
}
