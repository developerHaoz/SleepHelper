package com.example.developerhaoz.sleephelper.common.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * ViewPager + Fragment 通用的 Adapter
 *
 * Created by developerHaoz on 2017/5/2.
 */

public class CommonPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public CommonPagerAdapter(FragmentManager fragmentManager, List<Fragment> mFragments){
        super(fragmentManager);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}



















