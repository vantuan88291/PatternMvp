package com.tuan88291.patternmpvm.Utils.Room.LiveData;

import android.app.Application;

import com.tuan88291.patternmpvm.Model.RoomData.DataRoom;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MyViewModel extends AndroidViewModel {
    private WordRepository mRepository;

    private LiveData<List<DataRoom>> mAllWords;

    public MyViewModel (@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }


    public LiveData<List<DataRoom>> getAllData() { return mAllWords; }

    public void insert(DataRoom word) { mRepository.insert(word); }
}
