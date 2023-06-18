package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
TabLayout tab;
ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab=findViewById(R.id.tab);
        vp=findViewById(R.id.view_page);

        vpadapter adapter= new vpadapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }
}