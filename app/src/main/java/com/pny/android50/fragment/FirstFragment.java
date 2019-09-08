package com.pny.android50.fragment;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pny.android50.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    Bundle data ;
            TextView text;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        data =getArguments();

        String strData="";

        if(data != null){
            if(data.containsKey("name")){
                strData = "Name is :"+data.getString("name");
            }
            if(data.containsKey("gender")){
                strData += "\n Gender is "+ data.getString("gender");
            }
        }


        text =  v.findViewById(R.id.textView2);

        text.setText(strData);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int age = 18;

                data.putInt("age",age);

                if(getActivity()!=null){
                    // Manager who handles all fragments
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    // Helps in transition of fragments
                    FragmentTransaction ft = fm.beginTransaction();
                    // Fragment instance
                    SeconfFragment seconfFragment = new SeconfFragment();
                    seconfFragment.setArguments(data);
                    // command to add fragment to container
                    ft.add(R.id.container,seconfFragment).addToBackStack("FirstFragment");
                    // apply
                    ft.commit();
                }

            }
        });


        return v;

    }


}
