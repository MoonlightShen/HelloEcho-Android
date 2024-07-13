package com.echo.hello.util;

import android.content.Context;

import androidx.annotation.NonNull;

import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.XXPermissions;

public final class PermissionUtil {

    public static boolean checkPermission(Context context, String... permissions) {
        return XXPermissions.isGranted(context, permissions);
    }

    public static void requestPermission(Context context,@NonNull OnPermissionCallback callback, String... permissions) {
        XXPermissions.with(context)
                .permission(permissions)
                .request(callback);
    }

}
