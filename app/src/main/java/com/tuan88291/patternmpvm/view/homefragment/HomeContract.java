package com.tuan88291.patternmpvm.view.homefragment;

import com.tuan88291.patternmpvm.data.entity.DataRoom;

import java.util.List;

public interface HomeContract {
    void onLoading();
    void onSuccess();
    void onError();
    void onDataChange(List<DataRoom> data);
    interface HomePresenterView{
        void getApi();
    }
}
