package com.tuan88291.patternmpvm.view.fragment.homefragment;

import com.tuan88291.patternmpvm.BaseContract;
import com.tuan88291.patternmpvm.data.local.entity.DataRoom;

import java.util.List;

public interface HomeContract extends BaseContract {
    void onDataChange(List<DataRoom> data);
    interface HomePresenterView{
        void getApi();
    }
}
