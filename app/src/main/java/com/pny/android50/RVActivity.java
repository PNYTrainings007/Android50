package com.pny.android50;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.pny.android50.entity.ContactTable;

import java.util.ArrayList;
import java.util.List;

public class RVActivity extends AppCompatActivity {

    RecyclerView contactsRV;

    ArrayList<contact> contacts = new ArrayList<>();

    MobileDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);

        contactsRV = findViewById(R.id.contactsRV);



        database = MobileDatabase.getInstance(this);
        List<ContactTable> contacts = database.getContactsDao().getAllContacts();

        ContactAdapter adapter = new ContactAdapter(this,contacts);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        contactsRV.setLayoutManager(manager);

        contactsRV.setAdapter(adapter);


    }
/*
    public void populateData(){

        contact contact = new contact();
        contact.setName("hamza");
        contact.setNumber("0321 1231231");
        contact.setImage(R.drawable.agg);

        contacts.add(contact);

        contact contact1 = new contact();
        contact1.setName("ali");
        contact1.setNumber("0321 000000");
        contact1.setImage(R.drawable.agg);

        contacts.add(contact1);


        contact contact2 = new contact();
        contact2.setName("ahmed");
        contact2.setNumber("0321 00112233");
        contact2.setImage(R.drawable.agg);

        contacts.add(contact2);


        contact contact3 = new contact();
        contact3.setName("umer");
        contact3.setNumber("0321 12345678");
        contact3.setImage(R.drawable.agg);

        contacts.add(contact3);

        contact contact5 = new contact();
        contact5.setName("shoiab");
        contact5.setNumber("0321 101010101");
        contact5.setImage(R.drawable.agg);

        contacts.add(contact5);


        contact contact00 = new contact();
        contact00.setName("hamza");
        contact00.setNumber("0321 1231231");
        contact00.setImage(R.drawable.agg);

        contacts.add(contact00);

        contact contact11 = new contact();
        contact11.setName("ali");
        contact11.setNumber("0321 000000");
        contact11.setImage(R.drawable.agg);

        contacts.add(contact11);


        contact contact12 = new contact();
        contact12.setName("ahmed");
        contact12.setNumber("0321 00112233");
        contact12.setImage(R.drawable.agg);

        contacts.add(contact12);


        contact contact13 = new contact();
        contact13.setName("umer");
        contact13.setNumber("0321 12345678");
        contact13.setImage(R.drawable.agg);

        contacts.add(contact13);

        contact contact15 = new contact();
        contact15.setName("shoiab");
        contact15.setNumber("0321 101010101");
        contact15.setImage(R.drawable.agg);

        contacts.add(contact15);
    }*/
}