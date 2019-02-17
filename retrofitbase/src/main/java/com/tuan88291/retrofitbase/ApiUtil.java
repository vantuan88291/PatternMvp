package com.tuan88291.retrofitbase;

import android.content.Context;
import android.net.Uri;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtil {
    public static CallApi createApi() {
        return ServiceGenerator.createService(CallApi.class);
    }
    public static CallApi createApiOtherDomain() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://googleapis.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        return builder.build().create(CallApi.class);
    }

    public static CallApi createTokenApi() {
        return ServiceGenerator.createServiceToken(CallApi.class);
    }
}
