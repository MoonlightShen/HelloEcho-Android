package com.echo.hello.base.activity;

import android.app.NotificationManager;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import com.echo.hello.R;
import com.echo.hello.base.BaseModel;
import com.echo.hello.base.BaseViewModel;
import com.echo.hello.util.NotificationUtil;
import com.echo.hello.util.PermissionUtil;
import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;

import java.lang.reflect.ParameterizedType;

public abstract class BaseDataBindingActivity<VM extends BaseViewModel<M>, M extends BaseModel, VDB extends ViewDataBinding> extends BaseActivity {

    private VM viewModel;
    private VDB viewDataBinding;
    private Class<?>[] dispatchViewClasses;
    private int dispatchStrategy;

    protected final VM getViewModel() {
        return viewModel;
    }

    protected final M getModel() {
        return getViewModel().getModel();
    }

    protected final VDB getBinding() {
        return viewDataBinding;
    }

    protected VM createViewModel(){
        return (VM) new ViewModelProvider(this).get((Class<? extends BaseViewModel<? extends BaseModel>>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    protected M createModel(){
        try {
            return (M) ((Class<? extends BaseModel>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]).newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("初始化Model失败");
        }
    }

    @Override
    protected void initActivity() {
        //初始化binging
        viewDataBinding = DataBindingUtil.setContentView(this, getUILayoutId());
        //给binding加上感知生命周期（该抽象类继承了AppcompatActivity）
        viewDataBinding.setLifecycleOwner(this);

        viewModel = createViewModel();
        M model = createModel();
        model.setContext(this);
        model.setFragmentManager(this.getSupportFragmentManager());
        model.setHandler(handler);
        model.setLauncher(launcher);
        viewModel.setModel(model);
//        viewDataBinding.setVariable(BR.viewModel, viewModel);
    }
}
