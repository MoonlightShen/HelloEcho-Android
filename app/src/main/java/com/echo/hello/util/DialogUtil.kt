package com.echo.hello.util

import android.content.Context
import android.content.DialogInterface
import android.text.InputType
import com.afollestad.materialdialogs.DialogCallback
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.InputCallback
import com.afollestad.materialdialogs.input.input

class DialogUtil {
    companion object {
        @JvmStatic
        fun createNewBulb(
            context: Context,
            positiveCallback: DialogCallback?,
            inputCallback: InputCallback
        ) {
            MaterialDialog(context).show {
                title(text="添加设备")
                input(
                    inputType = InputType.TYPE_CLASS_TEXT,
                    callback = inputCallback
                )
                positiveButton(text = "确定", click = positiveCallback)
            }
        }
    }
}