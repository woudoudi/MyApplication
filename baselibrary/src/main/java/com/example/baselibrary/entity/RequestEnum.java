package com.example.baselibrary.entity;

public enum RequestEnum {

    VersionRequest1("",""),
    VersionRequest2("",""),
    VersionRequest3("",""),
    VersionRequest4("","");

    private String url;

    private String value;

    RequestEnum(String url, String value) {
        this.url = url;
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setKey(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
