package com.example.taller_n20_fragment_tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pager_controller extends FragmentPagerAdapter {

    int numoftabs;

    public pager_controller(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numoftabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new fragment_contactos();

            case 1:
                return new fragment_correos();

            case 2:
                return new fragment_mensajes();
        }
        return null;
    }

    @Override
    public int getCount(){
        return numoftabs;
    }
}
