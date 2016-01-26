package com.yalantis.flip.cinema.TwoFilm;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

/**
 * Created by kraft on 25.01.2016.
 */
public class TabAdapterTwo extends FragmentStatePagerAdapter {

    private  int numberOfTabs;

    public TabAdapterTwo(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }


    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0:
                return new TwoFilmsAbout();
            case 1:
                return new TwoFilmsTrailer();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
