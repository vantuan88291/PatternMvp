package com.tuan88291.patternmpvm.View.HomeFragment;

public interface HomeContract {
    void onLoading();
    void onSuccess();
    void onError();
    interface HomePresenterView{
        void getApi();
    }
}
