package com.echo.hello;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;

public class MyApp extends Application {
    private static Application context;
    private static SharedPreferences sharedPreferences;
    private static OkHttpClient client;
    private static Gson gson;

    public static Application getMyAppContext() {
        return context;
    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public static OkHttpClient getClient() {
        return client;
    }

    public static Gson getGson() {
        return gson;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        initGreenDao();
        initSharedPreferences();
        initOkHttpClient();
        initGson();

        initFontStyle();

    }

    private void initGreenDao() {
    }

    private void initSharedPreferences() {
        sharedPreferences = getSharedPreferences("app_data", Context.MODE_PRIVATE);
    }

    private void initOkHttpClient() {
        client = new OkHttpClient().newBuilder().build();
    }

    private void initGson() {
        gson = new Gson();
    }

    private void initFontStyle() {
    }


}
