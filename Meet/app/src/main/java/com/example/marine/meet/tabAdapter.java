package com.example.marine.meet;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by marinex on 26/6/17.
 */

public class tabAdapter extends FragmentStatePagerAdapter {
    int tabcount;
    List<MeetingData> data;
    public tabAdapter(List<MeetingData> data,FragmentManager fm, int tabcount) {
        super(fm);
        this.tabcount=tabcount;
        this.data=data;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                About about = new About();
                return about;
            case 1:
                Venue venue = new Venue();
                return venue;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
