package com.tuan88291.patternmpvm.data.room.livedata;

import android.app.Application;

import com.tuan88291.patternmpvm.data.entity.DataRoom;
import com.tuan88291.patternmpvm.data.room.AppDatabase;
import com.tuan88291.patternmpvm.data.room.QueriesDao;

import java.util.List;

import androidx.lifecycle.LiveData;
import easy.asyntask.tuan88291.library.AsyncTaskEasy;

public class WorkRepository {
    private QueriesDao mQueries;
    private LiveData<List<DataRoom>> mAllData;

    WorkRepository(Application application) {
        AppDatabase db = AppDatabase.getAppDatabase(application);
        mQueries = db.queries();
        mAllData = mQueries.getAll();
    }

    LiveData<List<DataRoom>> getAllData() {
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
