package com.pny.android50.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "ContactTable")
public class ContactTable implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "number")
    private String number;
    @ColumnInfo(name = "adddess")
    private String adddess;


    public ContactTable (int id ,String name, String number, String adddess ){
        this.name = name;
        this.number = number;
        this.adddess = adddess;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getAdddess() {
        return adddess;
    }
}
