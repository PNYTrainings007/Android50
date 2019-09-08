package com.pny.android50.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.pny.android50.entity.ContactTable;

import java.util.List;

@Dao
public interface ContactsDao {

    @Insert
    void insertContact(ContactTable contact);

    @Update
    void updateContact(ContactTable contact);

    @Delete
    void deleteContact(ContactTable contact);

    @Query("Select * From ContactTable")
    List<ContactTable> getAllContacts();

    @Query("Select * From ContactTable Where :name = name")
    List<ContactTable> getSingleContacts(String name);

}
