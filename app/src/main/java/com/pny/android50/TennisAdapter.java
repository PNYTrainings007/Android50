package com.pny.android50;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.util.PlatformVersion;
import com.pny.android50.entity.ContactTable;

import java.util.List;

public class TennisAdapter extends RecyclerView.Adapter<TennisAdapter.contactViewHolder> {

    private Activity activity;
    private List<Player> players;


    TennisAdapter(Activity activity , List<Player> players){
        this.activity = activity;
        this.players = players;
    }

    @NonNull
    @Override
    public contactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

         View v = LayoutInflater.from(activity).inflate(R.layout.row_contact,parent,false);
         return  new contactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull contactViewHolder holder, final int position) {

        final Player player = players.get(position);

        holder.contactName.setText(player.getName());
        holder.contactNumber.setText(player.getCity());

        Glide.with(activity).load(player.getImgURL()).into(holder.profilePic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return players.size();
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


