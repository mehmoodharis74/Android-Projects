package com.example.i200902;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;



import android.os.Bundle;


import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class main_page extends AppCompatActivity {
    DrawerLayout drawer_layout;
    Toolbar toolbar;
public boolean flag=true;
    @Override
    public  void onBackPressed() {
        drawer_layout=findViewById(R.id.drawerLayout);
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public void loadfrag(Fragment frag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag) {
            ft.add(R.id.mainFragContainer, frag);
        flag=false;
        }
        else
            ft.replace(R.id.mainFragContainer,frag);
        ft.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        ImageButton appbar_avatar=findViewById(R.id.appbar_avatar);
        appbar_avatar.setOnClickListener(view-> loadfrag(new profile_fagment()));

        BottomNavigationView bnview = findViewById(R.id.bn_view);


        bnview.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener(){
            @Override

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();

                if(id==R.id.nav_home)
                    loadfrag(new home_fragment());
                else if(id==R.id.nav_add)
                    loadfrag(new add_page_fragment());
                else if(id==R.id.nav_search)
                    loadfrag(new search_fragment());
                else if(id==R.id.nav_recent)
                    loadfrag(new recent_fragment());

                return true;
            }
        });
bnview.setSelectedItemId(R.id.nav_home);


    drawer_layout= findViewById(R.id.drawerLayout);
    NavigationView navigationview = findViewById(R.id.sidebar_navigation);
    toolbar= findViewById(R.id.toolbar);

    setSupportActionBar(toolbar);
    ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer_layout.addDrawerListener(toggle);
    toggle.syncState();


        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.nav_home)
                    loadfrag(new home_fragment());
                else if(id==R.id.nav_add)
                    loadfrag(new add_page_fragment());
                else if(id==R.id.nav_search)
                    loadfrag(new search_fragment());
                else if(id==R.id.nav_recent)
                    loadfrag(new recent_fragment());
                else
                    Toast.makeText(main_page.this, "Page not found!", Toast.LENGTH_SHORT).show();

                drawer_layout.closeDrawer(GravityCompat.START);

    //            else if(id==R.id.nav_profile)
    //                loadfrag(new profile_fagment());
    //            else if(id==R.id.nav_settings)
    //                loadfrag(new settings_fragment());
    //            else if(id==R.id.nav_logout)
    //                loadfrag(new logout_fragment());
                return true;
                }
        });
    }

}
