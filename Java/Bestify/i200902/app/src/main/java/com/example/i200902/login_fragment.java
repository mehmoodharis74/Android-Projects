package com.example.i200902;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class login_fragment extends Fragment {


    public login_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View views= inflater.inflate(R.layout.fragment_login_fragment, container, false);
        Button login=views.findViewById(R.id.login_btn);
        login.setOnClickListener(view->{
            Intent send_to_main_activity= new Intent(getActivity(), main_page.class);
            startActivity(send_to_main_activity);
            getActivity().finish();
        });

        return  views;

    }
}