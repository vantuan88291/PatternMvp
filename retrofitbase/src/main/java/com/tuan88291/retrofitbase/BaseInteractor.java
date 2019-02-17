package com.tuan88291.retrofitbase;

public abstract class BaseInteractor {
    private CallApi callApi;

    public BaseInteractor() {
        callApi = setCallAPi();
    }

    protected abstract CallApi setCallAPi();

    public CallApi getCallApi() {
        return callApi;
    }
}
