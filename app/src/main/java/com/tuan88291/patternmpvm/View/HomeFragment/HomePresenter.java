package com.tuan88291.patternmpvm.View.HomeFragment;

import android.content.Context;

import com.tuan88291.retrofitbase.ApiUtil;
import com.tuan88291.retrofitbase.BaseInteractor;
import com.tuan88291.retrofitbase.CallApi;
import com.tuan88291.retrofitbase.CustomCallBack.BaseRetrofit;
import com.tuan88291.retrofitbase.model.CommonData;

public class HomePresenter extends BaseInteractor implements HomeContract.HomePresenterView {

    private Context context;
    public HomePresenter(Context context){
        this.context = context;
    }


    @Override
    protected CallApi callAPi() {
        return ApiUtil.createApi();
    }

    @Override
    public void getApi() {

    }
}
