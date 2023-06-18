package com.example.i200902;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class add_page_fragment extends Fragment {



    public add_page_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View views= inflater.inflate(R.layout.add_page_fragment, container, false);
        Button add_play_list=views.findViewById(R.id.addPlaylist);
        add_play_list.setOnClickListener(view-> {
            //create toast printing message of Playlist added Successfully
            Context context = getContext();
            CharSequence text = "Playlist added Successfully";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            //set gravity of toast to bottom and leade some margin from bottom
            toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 200);
            toast.show();


        });
        return views;
    }
}