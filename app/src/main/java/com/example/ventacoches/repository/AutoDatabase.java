package com.example.ventacoches.repository;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ventacoches.dao.AutoDao;
import com.example.ventacoches.model.Auto;

@Database(entities = {Auto.class}, version = 1)
public abstract class AutoDatabase extends RoomDatabase{

    private static final String DB_NAME = "auto_db";
    private static final String DB_URL = "database/android_map.db";
    private static AutoDatabase instance;

    public static synchronized AutoDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AutoDatabase.class, DB_NAME).createFromAsset(DB_URL)
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }

        return instance;
    }

    public abstract AutoDao autoDao();

}
