package com.app.amrescuer.Adapter;

import com.app.amrescuer.Fragment.SliderFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class ViewPagerAdaptere extends FragmentPagerAdapter {
    List<String> list= new ArrayList<>();
    public ViewPagerAdaptere(FragmentManager fm, List<String> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return new SliderFragment();
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
