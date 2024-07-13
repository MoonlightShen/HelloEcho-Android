package com.echo.hello.base.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.echo.hello.R;

public class BaseGroupHeadViewHolder extends BaseViewHolder{
    final TextView contentText;
    public BaseGroupHeadViewHolder(@NonNull View itemView) {
        super(itemView);
        contentText = itemView.findViewById(R.id.group_content);
    }
}
