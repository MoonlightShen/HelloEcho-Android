package com.echo.hello.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.echo.hello.base.BaseViewModel;
import com.echo.hello.mvvm.model.DefaultModel;

public class DefaultViewModel extends BaseViewModel<DefaultModel> {
    public DefaultViewModel(@NonNull Application application) {
        super(application);
    }
}
