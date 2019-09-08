package com.pny.android50;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TimeBroadcastReciever  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Time is changed", Toast.LENGTH_SHORT).show();
    }
}
