package com.tuan88291.patternmpvm.data.room;

import com.tuan88291.patternmpvm.data.entity.DataRoom;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface QueriesDao {

    @Insert
    void insertData(DataRoom item);

    @Query("select * from user")
    LiveData<List<DataRoom>> getAll();
}