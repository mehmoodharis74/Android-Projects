package com.example.i200902;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class profile_fagment extends Fragment {



    public profile_fagment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View views= inflater.inflate(R.layout.profile_fagment, container, false);
        ImageButton next=views.findViewById(R.id.profile_id_edit_btn);
        next.setOnClickListener(view->{
            Intent send_to_main_activity= new Intent(getActivity(), profile_edit_activity.class);
            startActivity(send_to_main_activity);
        });

        return  views;
    }
}