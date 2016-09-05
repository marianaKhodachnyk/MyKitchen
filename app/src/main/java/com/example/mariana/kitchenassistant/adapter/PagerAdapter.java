package com.example.mariana.kitchenassistant.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mariana.kitchenassistant.fragments.TopRatedFragment;
import com.example.mariana.kitchenassistant.fragments.TrendingFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TopRatedFragment tab1 = new TopRatedFragment();
                return tab1;
            case 1:
                TrendingFragment tab2 = new TrendingFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
