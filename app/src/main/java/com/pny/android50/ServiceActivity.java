package com.pny.android50;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ServiceActivity extends AppCompatActivity {

    Button start,stop;

    TimeBroadcastReciever timeBroadcastReciever;
    IntentFilter action  = new IntentFilter(Intent.ACTION_TIME_TICK);

    public  static final String  localString = "com.pny.android50.DataTransfer";

    IntentFilter localFilter  = new IntentFilter(localString);


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        timeBroadcastReciever = new TimeBroadcastReciever();

        start = findViewById(R.id.startService);
        stop = findViewById(R.id.stopService);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent serviceIntent  = new Intent(ServiceActivity.this,MyService.class);
                startService(serviceIntent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent  = new Intent(ServiceActivity.this,MyService.class);
                stopService(serviceIntent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(timeBroadcastReciever,action);
        LocalBroadcastManager.getInstance(this).registerReceiver(localBroadcast,localFilter);
    }

    @Override
    protected void onStop(){
        unregisterReceiver(timeBroadcastReciever);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(localBroadcast);
        super.onStop();
    }

    BroadcastReceiver localBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent != null){
                if(intent.hasExtra("name")){
                    Toast.makeText(context, "Data recieved " + intent.getStringExtra("name"), Toast.LENGTH_SHORT).show();
                }
            }
            Toast.makeText(context, "local broadcast recieved", Toast.LENGTH_SHORT).show();
        }
    };
}
