package com.tuan88291.patternmpvm.view.about;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class AboutPresenter implements LifecycleObserver {
    static final AboutPresenter Instance = new AboutPresenter();
    private AboutContract contract;

    public static AboutPresenter getInstance() {
        return Instance;
    }

    public AboutPresenter setCallback(AboutContract contract) {
        this.contract = contract;
        return this;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void init() {
        contract.inCreate();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void inResume() {
        contract.inResume();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void indestroy() {
        contract.indestroy();
    }
}
