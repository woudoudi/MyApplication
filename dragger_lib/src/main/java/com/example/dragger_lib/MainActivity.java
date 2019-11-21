package com.example.dragger_lib;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.util.Log;

import com.example.dragger_lib.base.BaseActivity;
import com.example.dragger_lib.dragger.component.DaggerActivityComponent;
import com.example.dragger_lib.dragger.module.ActivityModule;
import com.example.dragger_lib.entity.Student;
import com.example.dragger_lib.mvp.presenter.LoginPresenter;
import com.example.dragger_lib.mvp.view.ICommonView;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements ICommonView {

    @Inject
    SharedPreferences sp;

    @Inject
    SharedPreferences sp1;

    @Inject
    Student mStudent;

    @Inject
    LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Student mStudent = DaggerEntityComponent.create().getStudent();




        Log.d("MainActivity","mPresenter="+mPresenter);
        Log.d("MainActivity","sp="+sp);
        Log.d("MainActivity","sp1="+sp1);
        Log.d("MainActivity","mStudent="+mStudent+",user="+mStudent.getUser());
//        presenter.request();

        CoordinatorLayout coordinatorLayout;
    }

    @Override
    protected void injectActivity() {
        super.injectActivity();

        DaggerActivityComponent.builder().
//                appComponent(ComponentHolder.getAppComponent()).
                activityModule(new ActivityModule(this)).
                build().
                inject(this);

//        DaggerCommonCompnent.
//                builder().
//                commonModule(new CommonModule(this)).
//                build().
//                Inject(this);

    }


    @Override
    public void getData(String data) {

    }
}
