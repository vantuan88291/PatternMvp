package com.tuan88291.patternmpvm.Utils.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.tuan88291.patternmpvm.Utils.Common.DOMAIN;


public class ServiceGenerator {
    private static OkHttpClient.Builder httpClient;
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(DOMAIN)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create());

    // service have not token
    public static <S> S createService(Class<S> serviceClass) {
        httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(3, TimeUnit.MINUTES);
        httpClient.connectTimeout(3, TimeUnit.MINUTES);
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            // Request customization: add request headers
            Request.Builder requestBuilder = original.newBuilder()
                    .addHeader("Content-Type", "application/json; charset=utf-8")
                    .addHeader("Accept", "application/json")
                    .method(original.method(), original.body());
            Request request = requestBuilder.build();
            return chain.proceed(request);
        });
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client) .addConverterFactory(GsonConverterFactory.create(gson)).build();
        return retrofit.create(serviceClass);
    }
    public static <S> S createServiceToken( Class<S> serviceClass) {
        httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(3, TimeUnit.MINUTES);
        httpClient.connectTimeout(3, TimeUnit.MINUTES);
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request requestBuilder = original.newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .method(original.method(), original.body()).build();
            return chain.proceed(requestBuilder);
        });
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }
}
