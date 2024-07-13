package com.echo.hello.util.databinding;

import androidx.databinding.BindingAdapter;

import com.xuexiang.xui.widget.button.switchbutton.SwitchButton;

public class CustomWidgetDataBinding {
    @BindingAdapter(value = "switch_status")
    public static void setSwitchStatus(SwitchButton status, boolean open){
        status.setChecked(open);
    }
}
