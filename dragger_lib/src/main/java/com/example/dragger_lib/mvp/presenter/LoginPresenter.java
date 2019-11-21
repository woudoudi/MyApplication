package com.example.dragger_lib.mvp.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.dragger_lib.mvp.model.User;
import com.example.dragger_lib.mvp.view.ICommonView;

import javax.inject.Inject;

public class LoginPresenter {

    ICommonView iView;

    @Inject
    public LoginPresenter(ICommonView iView) {

        this.iView = iView;
    }

    public void login(User user) {

        iView.getData("test");
    }
}
