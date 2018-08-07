package com.vegetarianbaconite.lazyknight.wear;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.vegetarianbaconite.schedulelib.MySchedule;

public class OverviewActivity extends FragmentActivity {
    FragmentStatePagerAdapter adapter;
    ViewPager pager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        pager = findViewById(R.id.wear_pager);
        pager.setAdapter(new FragAdapter(getSupportFragmentManager()));
    }

    private class FragAdapter extends FragmentStatePagerAdapter {

        public FragAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = new WearScheduleFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            f.setArguments(args);
            return f;
        }

        @Override
        public int getCount() {
            return MySchedule.currentSemester.size();
        }
    }
}
