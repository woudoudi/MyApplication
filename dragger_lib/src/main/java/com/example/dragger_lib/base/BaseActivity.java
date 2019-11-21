package com.example.dragger_lib.base;

import android.app.Activity;
import android.os.Bundle;


public class BaseActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        presenter.attachView(this);

        injectActivity();
    }

    protected void injectActivity(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        presenter.detachView();
    }
}
