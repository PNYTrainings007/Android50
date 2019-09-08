package com.pny.android50;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.widget.Toast;

import static com.pny.android50.ServiceActivity.localString;

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // background tasks
    @Override
    public int onStartCommand(Intent intent,
                              int flags, int startId) {

       for (int i =0 ;i<1000;i++){

           if(i==999){
               Intent data = new Intent(localString);
               data.putExtra("name","hamza");
               LocalBroadcastManager.getInstance(this).sendBroadcast(data);
           }
       }

        return super.onStartCommand(intent, flags, startId);
    }

    // destroy service
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service has stoped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
