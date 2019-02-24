package com.tuan88291.patternmpvm.data.service.customcallback;

import android.content.Context;

import com.blankj.utilcode.util.LogUtils;
import com.tuan88291.patternmpvm.BaseView;

import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public abstract class BaseRetrofit<T> {
    BaseView view;

    public BaseRetrofit(Call callback, BaseView view) {
        getRetrofit(callback);
        this.view = view;
    }

    private void getRetrofit(Call<T> callback) {
        onLoading();
        if (callback != null) {
            callback.enqueue(new CallBackBase<T>() {
                @Override
                public void onSuccess(Call<T> call, Response<T> response) {
                    if (response.isSuccessful()) {
                        try {
                            onGetApiComplete(response);
                        } catch (Exception e) {
                            onFail(e.getLocalizedMessage());
                            LogUtils.a("Exeption fire: " + e.toString());
                        }
                    } else {
                        onFail(getMessage(response));
                        view.setErrorParent(getMessage(response));
                        LogUtils.a("response not successful: " + response.toString());

                    }
                    onLoadComplete();
                }

                @Override
                public void onError(Call<T> call, Throwable t) {
                    if (t instanceof IOException) {
                        onFail("Check your network");
                    } else {
                        onFail(t.getLocalizedMessage());
                    }
                    LogUtils.a("onError: " + t.toString());
                    onLoadComplete();
                }
            });

        } else {
            onFail("callback can not be null");
            LogUtils.a("callback null");
            onLoadComplete();
        }

    }

    private String getMessage(Response<T> response) {
        String mess = "";
        try {
            String errorBody = response.errorBody().string();
            JSONObject jObjError = new JSONObject(errorBody);
            mess = jObjError.getString("message");
        } catch (Exception e) {
            mess = "Can not get message!";
            LogUtils.a("Can not get message!", response.toString());

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
