package com.tuan88291.retrofitbase;

import android.content.Context;
import android.net.Uri;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;

import io.reactivex.annotations.NonNull;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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
    @NonNull
    public static MultipartBody.Part prepareFilePart(Context context, String partName, Uri fileUri, File file) {
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
    }

    @NonNull
    public static RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                MultipartBody.FORM, descriptionString);
    }
}
