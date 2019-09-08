package com.pny.android50.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pny.android50.R;


public class SeconfFragment extends Fragment {

    public SeconfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        Bundle  args = getArguments();

        Toast.makeText(getActivity(), "Age recieved is"+args.getInt("age"), Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_seconf, container, false);
    }
}
