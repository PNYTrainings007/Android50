package com.pny.android50;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pny.android50.entity.ContactTable;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.contactViewHolder> {

    private Activity activity;
    private List<ContactTable> contacts;

    MobileDatabase database;

    ContactAdapter(Activity activity ,  List<ContactTable> contacts){
        this.activity = activity;
        this.contacts = contacts;

        database = MobileDatabase.getInstance(activity);
    }

    @NonNull
    @Override
    public contactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

         View v = LayoutInflater.from(activity).inflate(R.layout.row_contact,parent,false);
         return  new contactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull contactViewHolder holder, final int position) {

        final ContactTable contact = contacts.get(position);

        holder.contactName.setText(contact.getName());
        holder.contactNumber.setText(contact.getNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database.getContactsDao().deleteContact(contact);

                contacts = database.getContactsDao().getAllContacts();

                notifyDataSetChanged();


            }
        });



    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

     class contactViewHolder extends RecyclerView.ViewHolder{

        TextView contactName;
        TextView contactNumber;
        ImageView profilePic;

        contactViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contactName);
            contactNumber = itemView.findViewById(R.id.contactNumber);
            profilePic = itemView.findViewById(R.id.profilePic);

        }
    }

}


