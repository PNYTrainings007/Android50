package com.pny.android50;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.pny.android50.dao.ContactsDao;
import com.pny.android50.entity.ContactTable;

@Database(entities = ContactTable.class, version = 1)
public abstract class MobileDatabase extends RoomDatabase {

    private static final String DB_NAME = "mobile_database";
    private static MobileDatabase instance;

    static synchronized MobileDatabase getInstance(Context context){

        if(instance == null){
            instance = Room.databaseBuilder(context,MobileDatabase.class,DB_NAME)
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }

        return instance;
    }

    public abstract ContactsDao getContactsDao();

}
