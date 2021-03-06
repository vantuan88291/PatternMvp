package com.tuan88291.patternmpvm.view.fragment.homefragment;

import com.tuan88291.patternmpvm.data.local.model.CommonData;
import com.tuan88291.patternmpvm.data.remote.ApiUtil;
import com.tuan88291.patternmpvm.data.remote.BaseInteractor;
import com.tuan88291.patternmpvm.data.remote.CallApi;
import com.tuan88291.patternmpvm.data.remote.customcallback.BaseRetrofit;

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

        new BaseRetrofit<CommonData>(callAPi().getList(), v) {
            @Override
            protected void onGetApiComplete(Response<CommonData> response) {

            }

            @Override
            protected void onFail(String err) {
                v.onError(err);
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
