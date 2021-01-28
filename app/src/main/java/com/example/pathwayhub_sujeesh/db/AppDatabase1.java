/*
package com.example.pathwayhub_sujeesh.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pathwayhub_sujeesh.network.PathPojo;


@Database(entities = {PathPojo.Response.Doc.class}, version = 1, exportSchema = false)
public abstract class AppDatabase1 extends RoomDatabase {

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "ownPath";
    private static com.example.pathwayhub_sujeesh.db.AppDatabase1 sInstance;

    public static com.example.pathwayhub_sujeesh.db.AppDatabase1 getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {

                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        com.example.pathwayhub_sujeesh.db.AppDatabase1.class, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return sInstance;
    }

    public abstract PathDao pathDao();
}
*/
