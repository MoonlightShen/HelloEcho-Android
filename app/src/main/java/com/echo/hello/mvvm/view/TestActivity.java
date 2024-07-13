package com.echo.hello.mvvm.view;

import com.echo.hello.R;
import com.echo.hello.base.activity.BaseDataBindingActivity;
import com.echo.hello.databinding.ActivityTestBinding;
import com.echo.hello.mvvm.model.DefaultModel;
import com.echo.hello.mvvm.viewmodel.DefaultViewModel;

public class TestActivity extends BaseDataBindingActivity<DefaultViewModel, DefaultModel, ActivityTestBinding> {

    @Override
    protected int getUILayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initOnMainThread() {

    }

    @Override
    protected void initInBackground() {

    }
}