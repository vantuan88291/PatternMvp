package com.tuan88291.patternmpvm.Utils.Room;

import com.tuan88291.patternmpvm.Model.RoomData.DataRoom;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface Queries {

    @Insert
    void insertData(DataRoom item);

    @Query("select * from user")
    LiveData<List<DataRoom>> getAll();
}