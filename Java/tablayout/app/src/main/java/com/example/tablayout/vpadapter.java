package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class vpadapter extends FragmentPagerAdapter {
    public vpadapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return  new frag1();
        else if(position==1)
            return  new frag2();
        else{
            return new frag3();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return  "Chats";
        else if(position==1)
            return  "Groups";
        else{
            return "Calls";
        }
//       return super.getPageTitle(position);
    }
}
