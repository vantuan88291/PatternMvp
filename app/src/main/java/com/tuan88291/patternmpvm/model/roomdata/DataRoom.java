package com.tuan88291.patternmpvm.model.roomdata;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class DataRoom {

    @PrimaryKey(autoGenerate = true)
    public long mId;

    @ColumnInfo(name = "name")
    private String name;


    @ColumnInfo(name = "age")
    private int age;

    public DataRoom(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public DataRoom(){}

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}