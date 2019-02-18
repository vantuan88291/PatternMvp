package com.tuan88291.patternmpvm;
import com.google.gson.Gson;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class App extends MultiDexApplication {
    private static App instance;
    private Gson mGSon;
    public static App getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        instance = this;
        mGSon = new Gson();
    }
    public Gson getGSon() {
        return mGSon;
    }
}

