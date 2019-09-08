package com.pny.android50;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pny.android50.fragment.FirstFragment;

public class FragmentActivity extends AppCompatActivity {

    Button launchFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        launchFragment = findViewById(R.id.launchFragment);

        launchFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = "hamza";
                String gender = "male";

                Bundle bundle =  new Bundle();

                bundle.putString("name",name);
                bundle.putString("gender",gender);

                // Manager who handles all fragments
                FragmentManager fm = getSupportFragmentManager();
                // Helps in transition of fragments
                FragmentTransaction ft = fm.beginTransaction();
                // Fragment instance
                FirstFragment firstFragment = new FirstFragment();
                // Passing Data to Fragment
                firstFragment.setArguments(bundle);
                // command to add fragment to container
                ft.add(R.id.container,firstFragment);
                // apply
                ft.commit();


            }
        });
    }
}
