package com.tuan88291.patternmpvm.data.room.livedata;

import android.app.Application;

import com.tuan88291.patternmpvm.data.entity.DataRoom;
import com.tuan88291.patternmpvm.data.room.AppDatabase;
import com.tuan88291.patternmpvm.data.room.QueriesDao;

import java.util.List;

import androidx.lifecycle.LiveData;
import easy.asyntask.tuan88291.library.AsyncTaskEasy;

public class WordRepository {
    private QueriesDao mQueries;
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
