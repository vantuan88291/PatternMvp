package com.tuan88291.patternmpvm.Utils.retrofit.CustomCallBack;

import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class CallBackBase<T> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        LogUtils.a(call.request().toString() + "\n" + new Gson().toJson(response.body()));
        onSuccess(call,response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        LogUtils.a(call.request().toString() + "\n" + t.getMessage());
        onError(call,t);
    }
    protected abstract void onSuccess(Call<T> call, Response<T> response) ;
    protected abstract void onError(Call<T> call,  Throwable t);
}
