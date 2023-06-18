package com.example.i200902;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class profile_edit_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit);

        Button confirmBtn=findViewById(R.id.edit_profile_confirm_btn);
        confirmBtn.setOnClickListener(view->{
            super.onBackPressed();
        });
    }
}