package com.tuan88291.commonlib;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDexApplication;

public class BaseApp extends MultiDexApplication {
    private static BaseApp instance;

    public BaseApp() {
        instance = this;
    }
    public static Context getContext() {
        return instance;
    }
}
