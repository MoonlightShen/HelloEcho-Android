package com.echo.hello.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.echo.hello.MyApp;
import com.echo.hello.R;
import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;

public final class NotificationUtil {
    private static final String NORMAL_CHANNEL_ID = "NORMAL_CHANNEL_ID";
    private static final String NORMAL_CHANNEL_NAME = "normalChannelName";

    private static final int NORMAL_NOTIFICATION_ID = 10000;

    public static boolean checkNotificationPermission(){
        return PermissionUtil.checkPermission(MyApp.getMyAppContext(), Permission.POST_NOTIFICATIONS);
    }

    public static void requestNotificationPermission(OnPermissionCallback callback){
        PermissionUtil.requestPermission(MyApp.getMyAppContext(), callback, Permission.POST_NOTIFICATIONS);
    }

    public static void createNormalNotification(@NonNull NotificationManager mManager, boolean showBadge, @NonNull Context context, @NonNull Intent intent,
                                                String title, String content, int smallIconRes, Bitmap largeIcon, @NonNull NotificationPriority priority, boolean autoCancel) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(NORMAL_CHANNEL_ID, NORMAL_CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW);
            channel.setDescription("");
            channel.setShowBadge(showBadge);
            mManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, NORMAL_CHANNEL_ID);
        if (title != null) builder.setContentTitle(title);
        if (content != null) builder.setContentText(content);
        builder.setSmallIcon(smallIconRes);
        if (largeIcon != null) builder.setLargeIcon(largeIcon);
        builder.setPriority(priority.value);
        builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE));
        builder.setAutoCancel(autoCancel);
        mManager.notify(NORMAL_NOTIFICATION_ID, builder.build());
    }

    public enum NotificationPriority {
        MIN(-2),
        LOW(-1),
        DEFAULT(0),
        HIGH(1),
        MAX(2);

        final int value;

        NotificationPriority(int value) {
            this.value = value;
        }
    }

    public enum NotificationCategory {
        //TODO 通知类别，适用“勿扰模式”
    }

    public enum NotificationVisibility {
        //TODO 屏幕可见性，适用“锁屏状态”
    }



    public static final class NotificationBuilder {
        private final NotificationCompat.Builder builder;
        private String title; //标题
        private String content; //内容
        private String subText; //子标题
        private Bitmap largeIcon; //大图标
        private int smallIconRes = R.mipmap.ic_launcher;
        private boolean autoCancel = true;
        private int number = 1;

        NotificationBuilder(Context context, String channelId, Intent contentIntent) {
            builder = new NotificationCompat.Builder(context, channelId);
            builder.setContentIntent(PendingIntent.getActivity(context, 0, contentIntent, PendingIntent.FLAG_IMMUTABLE));
        }

        Notification build() {
            return builder.setContentTitle(title)
                    .setContentText(content)
                    .setSubText(subText)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(smallIconRes)
                    .setAutoCancel(autoCancel)
                    .setNumber(number)
                    .build();
        }

        public NotificationBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public NotificationBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public NotificationBuilder setSubText(String subText) {
            this.subText = subText;
            return this;
        }

        public NotificationBuilder setLargeIcon(Bitmap largeIcon) {
            this.largeIcon = largeIcon;
            return this;
        }

        public NotificationBuilder setSmallIconRes(int smallIconRes) {
            this.smallIconRes = smallIconRes;
            return this;
        }

        public NotificationBuilder setAutoCancel(boolean autoCancel) {
            this.autoCancel = autoCancel;
            return this;
        }

        public NotificationBuilder setNumber(int number) {
            this.number = number;
            return this;
        }
    }
}
