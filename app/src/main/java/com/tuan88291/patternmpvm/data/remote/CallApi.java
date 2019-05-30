package com.tuan88291.patternmpvm.data.remote;


import com.tuan88291.patternmpvm.data.local.model.CommonData;
import com.tuan88291.patternmpvm.data.local.model.Data;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CallApi {
    @GET("api")
    Call<CommonData> getList();
    @FormUrlEncoded
    @POST("api")
    Call<CommonData<Data>> getListMore();
}
