package com.tuan88291.patternmpvm;
import com.tuan88291.commonlib.BaseApp;
import androidx.multidex.MultiDex;
public class App extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }
}

