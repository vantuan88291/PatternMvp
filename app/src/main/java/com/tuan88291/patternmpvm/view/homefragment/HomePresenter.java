package com.tuan88291.patternmpvm.view.homefragment;

import android.content.Context;

import com.tuan88291.patternmpvm.data.model.CommonData;
import com.tuan88291.patternmpvm.data.service.ApiUtil;
import com.tuan88291.patternmpvm.data.service.BaseInteractor;
import com.tuan88291.patternmpvm.data.service.CallApi;
import com.tuan88291.patternmpvm.data.service.customcallback.BaseRetrofit;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import retrofit2.Response;

public class HomePresenter extends BaseInteractor implements LifecycleObserver, HomeContract.HomePresenterView {

    private HomeContract v;
    static final HomePresenter presenter = new HomePresenter();
    public static HomePresenter getInstance(){
        return presenter;
    }
    public HomePresenter setCallBack(HomeContract v){
        this.v = v;
        return this;
    }


    @Override
    protected CallApi callAPi() {
        return ApiUtil.createApi();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    @Override
    public void getApi() {

        new BaseRetrofit<CommonData>(callAPi().getList()) {
            @Override
            protected void onGetApiComplete(Response<CommonData> response) {

            }

            @Override
            protected void onFail(String err) {
                v.onError(err);

                v.setErrorParent(err);
            }

            @Override
            protected void onLoading() {
                super.onLoading();
                v.onLoading();
            }

            @Override
            protected void onLoadComplete() {
                super.onLoadComplete();
                v.onLoadComplete();
            }
        };
    }



}
