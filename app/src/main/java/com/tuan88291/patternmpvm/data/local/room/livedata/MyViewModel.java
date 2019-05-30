package com.tuan88291.patternmpvm.data.local.room.livedata;

import android.app.Application;

import com.tuan88291.patternmpvm.data.local.entity.DataRoom;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MyViewModel extends AndroidViewModel {
    private WorkRepository mRepository;

    private LiveData<List<DataRoom>> mAllWords;

    public MyViewModel (@NonNull Application application) {
        super(application);
        mRepository = new WorkRepository(application);
        mAllWords = mRepository.getAllData();
    }


    public LiveData<List<DataRoom>> getAllData() { return mAllWords; }

    public void insert(DataRoom word) { mRepository.insert(word); }
}
