package com.tuan88291.retrofitbase;

import com.tuan88291.retrofitbase.model.CommonData;
import com.tuan88291.retrofitbase.model.Data;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CallApi {
    @GET("api")
    Observable<CommonData> getListNotifi2(@Query("user_type") int user_type);
    @FormUrlEncoded
    @POST("api")
    Observable<CommonData<Data>> deleteAllNotifications2(@Field("user_type") int user_type);
}
