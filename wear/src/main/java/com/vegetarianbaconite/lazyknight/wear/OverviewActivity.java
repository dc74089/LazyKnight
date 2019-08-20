package com.vegetarianbaconite.lazyknight.wear;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.vegetarianbaconite.schedulelib.Schedules;

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
            return Schedules.currentSemester.size();
        }
    }
}
