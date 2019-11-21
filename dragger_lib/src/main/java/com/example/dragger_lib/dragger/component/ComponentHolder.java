package com.example.dragger_lib.dragger.component;

public class ComponentHolder {

    private static AppComponent myAppComponent;

    public static void setAppComponent(AppComponent component) {
        myAppComponent = component;
    }

    public static AppComponent getAppComponent() {
        return myAppComponent;
    }
}
