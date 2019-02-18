package com.tuan88291.patternmpvm.Model.CommonData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommonData<T> {
    @SerializedName("data")
    @Expose
    T data;
    @SerializedName("status_code")
    @Expose
    int code;
    @SerializedName("message")
    @Expose
    String message;

    public T getData() {

        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
