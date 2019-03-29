package com.tuan88291.patternmpvm.utils.observe;

import com.blankj.utilcode.util.LogUtils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class AutoDisposable implements LifecycleObserver {
    private CompositeDisposable compositeDisposable;
    public void bindTo(Lifecycle lifecycle){
        lifecycle.addObserver(this);
        compositeDisposable = new CompositeDisposable();
    }
    public void add(Disposable disposable) throws Exception {
        if (compositeDisposable != null) {
            compositeDisposable.add(disposable);
        }else {
            throw new Exception("must bind AutoDisposable to a Lifecycle first");
        }
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(){
        compositeDisposable.dispose();
        LogUtils.a("disssssssssss");
    }
}
