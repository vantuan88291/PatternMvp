package com.tuan88291.patternmpvm.Utils.Room.LiveData;

import android.app.Application;

import com.tuan88291.patternmpvm.Model.RoomData.DataRoom;
import com.tuan88291.patternmpvm.Utils.Room.AppDatabase;
import com.tuan88291.patternmpvm.Utils.Room.Queries;

import java.util.List;

import androidx.lifecycle.LiveData;
import easy.asyntask.tuan88291.library.AsyncTaskEasy;

public class WordRepository {
    private Queries mQueries;
    private LiveData<List<DataRoom>> mAllData;

    WordRepository(Application application) {
        AppDatabase db = AppDatabase.getAppDatabase(application);
        mQueries = db.queries();
        mAllData = mQueries.getAll();
    }

    LiveData<List<DataRoom>> getAllWords() {
        return mAllData;
    }


    public void insert (DataRoom data) {
        new AsyncTaskEasy() {
            @Override
            protected Object doBackground() {
                mQueries.insertData(data);
                return null;
            }
        };
    }
}
