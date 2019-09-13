package com.pny.android50;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pny.android50.entity.ContactTable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ContactsDBActivity extends AppCompatActivity {

    Button insert, update, delete, fetch;

    EditText contactName, contactNumber, contactAddress;

    String strContactName, strContactNumber, strCntactAddress;

    MobileDatabase database;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_db);

        sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);
        database = MobileDatabase.getInstance(this);

        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        fetch = findViewById(R.id.fetch);
        contactName = findViewById(R.id.contactName);
        contactNumber = findViewById(R.id.contactsNumber);
        contactAddress = findViewById(R.id.contactAddress);

        String oldName = sharedPreferences.getString("name", "no value found");
        contactName.setText(oldName);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();

                ContactTable table = new ContactTable(0, strContactName, strContactNumber, strCntactAddress);

                database.getContactsDao().insertContact(table);

                SharedPreferences.Editor editor;
                editor = sharedPreferences.edit();
                editor.putString("name", strContactName);
                editor.apply();

            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();


                ContactTable table = new ContactTable(1, strContactName, strContactNumber, strCntactAddress);

                database.getContactsDao().updateContact(table);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();


                ContactTable table = new ContactTable(1, strContactName, strContactNumber, strCntactAddress);

                database.getContactsDao().deleteContact(table);
            }
        });


        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ContactsDBActivity.this, RVActivity.class);
                startActivity(intent);


                // Toast.makeText(ContactsDBActivity.this, contacts.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void getValues() {
        strContactName = contactName.getText().toString();
        strContactNumber = contactNumber.getText().toString();
        strCntactAddress = contactAddress.getText().toString();
    }

    String json = "{\"status\":\"true\",\"message\":\"Data fetched successfully!\",\"data\":[{\"id\":\"1\",\"name\":\"Roger Federer\",\"country\":\"Switzerland\",\"city\":\"Basel\",\"imgURL\":\"https:\\/\\/demonuts.com\\/Demonuts\\/SampleImages\\/roger.jpg\"},{\"id\":\"2\",\"name\":\"Rafael Nadal\",\"country\":\"Spain\",\"city\":\"Madrid\",\"imgURL\":\"https:\\/\\/demonuts.com\\/Demonuts\\/SampleImages\\/nadal.jpg\"},{\"id\":\"3\",\"name\":\"Novak Djokovic\",\"country\":\"Serbia\",\"city\":\"Monaco\",\"imgURL\":\"https:\\/\\/demonuts.com\\/Demonuts\\/SampleImages\\/djoko.jpg\"},{\"id\":\"4\",\"name\":\"Andy Murray\",\"country\":\"United Kingdom\",\"city\":\"London\",\"imgURL\":\"https:\\/\\/demonuts.com\\/Demonuts\\/SampleImages\\/murray.jpg\"},{\"id\":\"5\",\"name\":\"Maria Sharapova\",\"country\":\"Russia\",\"city\":\"Moscow\",\"imgURL\":\"https:\\/\\/demonuts.com\\/Demonuts\\/SampleImages\\/shara.jpg\"},{\"id\":\"6\",\"name\":\"Caroline Wozniacki\",\"country\":\"Denmark\",\"city\":\"Odense\",\"imgURL\":\"https:\\/\\/demonuts.com\\/Demonuts\\/SampleImages\\/woz.jpg\"},{\"id\":\"7\",\"name\":\"Eugenie Bouchard\",\"country\":\"Canada\",\"city\":\" Montreal\",\"imgURL\":\"https:\\/\\/demonuts.com\\/Demonuts\\/SampleImages\\/bou.png\"},{\"id\":\"8\",\"name\":\"Ana Ivanovic\",\"country\":\"Serbia\",\"city\":\"Belgrade\",\"imgURL\":\"https:\\/\\/demonuts.com\\/Demonuts\\/SampleImages\\/iva.jpg\"}]}";




}
