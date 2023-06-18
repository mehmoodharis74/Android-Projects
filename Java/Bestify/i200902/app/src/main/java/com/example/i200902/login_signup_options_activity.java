package com.example.i200902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class login_signup_options_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_login_options);
        Button google_login=findViewById(R.id.btn_continue_with_google);
        Button facebook_login=findViewById(R.id.btn_continue_with_facebook);
        Button email_login=findViewById(R.id.btn_continue_with_email);
        google_login.setOnClickListener(view -> {

            String URL = "https://accounts.google.com/ServiceLogin/webreauth?service=accountsettings&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
            Uri webpage= Uri.parse(URL);
            Intent open_page=new Intent(Intent.ACTION_VIEW,webpage);
            startActivity(open_page);

        });
        facebook_login.setOnClickListener(view -> {
            String URL = "https://www.facebook.com/login/";
            Uri webpage= Uri.parse(URL);
            Intent open_page=new Intent(Intent.ACTION_VIEW,webpage);
            startActivity(open_page);
            finish();
        });
        email_login.setOnClickListener(view -> {
            Intent email_sign=new Intent(login_signup_options_activity.this,email_sign_activity.class);
            startActivity(email_sign);
            finish();
        });



    }
}