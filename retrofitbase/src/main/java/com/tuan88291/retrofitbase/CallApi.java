package com.tuan88291.retrofitbase;

import com.tuan88291.retrofitbase.model.CommonData;
import com.tuan88291.retrofitbase.model.Data;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CallApi {
    @GET("api")
    Call<CommonData> getList();
    @FormUrlEncoded
    @POST("api")
    Call<CommonData<Data>> getListMore();
}
