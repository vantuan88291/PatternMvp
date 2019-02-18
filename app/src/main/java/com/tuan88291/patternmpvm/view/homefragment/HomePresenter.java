package com.tuan88291.patternmpvm.view.homefragment;

import android.content.Context;
import android.widget.Toast;

import com.tuan88291.patternmpvm.data.model.CommonData;
import com.tuan88291.patternmpvm.data.service.ApiUtil;
import com.tuan88291.patternmpvm.data.service.BaseInteractor;
import com.tuan88291.patternmpvm.data.service.CallApi;
import com.tuan88291.patternmpvm.data.service.CustomCallBack.BaseRetrofit;

import retrofit2.Response;

public class HomePresenter extends BaseInteractor implements HomeContract.HomePresenterView {

    private Context context;
    private HomeContract v;
    public HomePresenter(Context context, HomeContract v){
        this.context = context;
        this.v = v;
    }


    @Override
    protected CallApi callAPi() {
        return ApiUtil.createApi();
    }

    @Override
    public void getApi() {

        new BaseRetrofit<CommonData>(context, callAPi().getList()) {
            @Override
            protected void onGetApiComplete(Response<CommonData> response) {

                Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onFail(String err) {
                Toast.makeText(context, err, Toast.LENGTH_SHORT).show();

            }

            @Override
            protected void onLoading() {
                super.onLoading();
                v.onLoading();
            }

            @Override
            protected void onLoadComplete() {
                super.onLoadComplete();
                v.onSuccess();
            }
        };
    }



}
