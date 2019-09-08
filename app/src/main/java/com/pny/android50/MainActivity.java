package com.pny.android50;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonOutput;
    EditText inputEditText;
    TextView outputTextView;

    String myInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // this line links backend to the front end
        setContentView(R.layout.activity_main);

        buttonOutput = findViewById(R.id.buttonOutput);
        inputEditText = findViewById(R.id.inputEditText);

        buttonOutput.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myInput = inputEditText.getText().toString();
                        Intent goToNext = new Intent(MainActivity.this,DataActivity.class);
                        goToNext.putExtra("input",myInput);
                        startActivity(goToNext);
                      //  finish();
                    }
                });

        Log.i("MainActivity","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Network call
        Log.i("MainActivity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy");
    }
}

