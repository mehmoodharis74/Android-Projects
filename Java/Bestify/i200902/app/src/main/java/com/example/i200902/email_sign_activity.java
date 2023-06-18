package com.example.i200902;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class email_sign_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sign);

        loadFragment(new register_fragment(),0);
        Button  swap_register=findViewById(R.id.swap_register_btn);
        Button swap_login=findViewById(R.id.swap_login_btn);


       swap_register.setOnClickListener(view -> loadFragment(new register_fragment(),1));
       swap_login.setOnClickListener(view -> loadFragment(new login_fragment(),1));

       //button listeners



    }

    public void loadFragment(Fragment fragment, int flag){
        FragmentManager frag=getSupportFragmentManager();
        FragmentTransaction fragmentation=frag.beginTransaction();
        if(flag==0)
        fragmentation.add(R.id.login_signup_fragment,fragment);
        else fragmentation.replace(R.id.login_signup_fragment, fragment);
        fragmentation.commit();
    }
}