package com.echo.hello.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.echo.hello.base.BaseViewModel;
import com.echo.hello.mvvm.model.ItemListModel;


public class ItemListViewModel<T, VH extends RecyclerView.ViewHolder> extends BaseViewModel<ItemListModel<T, VH>> {
    public ItemListViewModel(@NonNull Application application) {
        super(application);
    }

}
