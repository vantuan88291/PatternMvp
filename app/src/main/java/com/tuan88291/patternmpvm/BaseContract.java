package com.tuan88291.patternmpvm;

public interface BaseContract extends BaseView{
    void onLoading();
    void onLoadComplete();
    void onError(String mess);
}
