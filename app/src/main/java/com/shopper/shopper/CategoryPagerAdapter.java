package com.shopper.shopper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CategoryPagerAdapter extends FragmentStatePagerAdapter {

    private int mSize;

    public CategoryPagerAdapter(FragmentManager fm, int mSize) {
        super(fm);
        this.mSize = mSize;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                CategoryFragment tab1 = new CategoryFragment();
                return tab1;
            case 1:
                CategoryFragment tab2 = new CategoryFragment();
                return tab2;




            default:

                CategoryFragment deafa = new CategoryFragment();

                return deafa;
        }
    }

    @Override
    public int getCount() {
        return mSize;
    }
}