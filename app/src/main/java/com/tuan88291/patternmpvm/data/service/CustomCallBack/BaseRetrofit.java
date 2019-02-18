package com.tuan88291.patternmpvm.data.service.CustomCallBack;

import android.content.Context;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public abstract class BaseRetrofit<T> {
    private Context context;
    public BaseRetrofit(Context context, Call callback){
        this.context = context;
        getRetrofit(callback);
    }

    private void getRetrofit(Call<T> callback){
        onLoading();
        if (callback != null) {
            callback.enqueue(new CallBackBase<T>() {
                @Override
                public void onSuccess(Call<T> call, Response<T> response) {
                    if (response.isSuccessful()) {
                        try {
                            if (response.code() == 401) {
                                onFail(getMessage(response));
                            } else {
                                onGetApiComplete(response);
                            }
                        } catch (Exception e) {
                            onFail(e.getLocalizedMessage());
                        }
                    }else {
                        onFail(getMessage(response));
                    }
                    onLoadComplete();
                }

                @Override
                public void onError(Call<T> call, Throwable t) {
                    if (t instanceof IOException) {
                        onFail("Check your network");
                    }else {
                        onFail(t.getLocalizedMessage());
                    }

                    onLoadComplete();
                }
            });

        } else {
            onFail("callback can not be null");
            onLoadComplete();
        }

    }
    private String getMessage(Response<T> response){
        String mess = "";
        try {
            String errorBody = response.errorBody().string();
            JSONObject jObjError = new JSONObject(errorBody);
            mess = jObjError.getString("message");
        } catch (Exception e) {
            mess = "Can not get message!";
        }
        return mess;
    }

    protected abstract void onGetApiComplete(Response<T> response);

    protected void onLoading() {

    }

    protected void onLoadComplete() {

    }

    protected abstract void onFail(String err);

}
