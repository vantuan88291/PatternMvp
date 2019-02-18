package com.tuan88291.patternmpvm.View.HomeFragment;

import com.tuan88291.patternmpvm.Model.RoomData.DataRoom;

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
