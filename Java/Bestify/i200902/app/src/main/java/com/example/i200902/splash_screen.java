package com.example.i200902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed((Runnable) () -> {
            Intent splash= new Intent(splash_screen.this, login_signup_options_activity.class);
            startActivity(splash);
            finish();
        }, 2500);
    }
}