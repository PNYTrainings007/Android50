package com.pny.android50;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Log.i("DataActivity", "onCreate");

        textView = findViewById(R.id.textView);
        Intent intent = getIntent();

        if (intent != null) {
            if (intent.hasExtra("input")) {
                String data = intent.getStringExtra("input");
                textView.setText(data);
            }
            else {
                textView.setText("no data found");
            }
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Network call
        Log.i("DataActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("DataActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("DataActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("DataActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("DataActivity", "onDestroy");
    }
}
