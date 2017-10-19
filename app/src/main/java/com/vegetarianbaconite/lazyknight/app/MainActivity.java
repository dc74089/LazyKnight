package com.vegetarianbaconite.lazyknight.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.vegetarianbaconite.schedulelib.MySchedule;

public class MainActivity extends FragmentActivity {
    FragmentStatePagerAdapter adapter;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FragAdapter(getSupportFragmentManager());
        pager = findViewById(R.id.mPager);
        pager.setAdapter(adapter);
    }

    private class FragAdapter extends FragmentStatePagerAdapter {
        public FragAdapter(FragmentManager fm) {
            super(fm);
            Log.d("Activity", "FragAdapter created");
        }

        @Override
        public Fragment getItem(int position) {
            if (position > 0) {
                Fragment f = new ScheduleFragment();
                Bundle args = new Bundle();
                args.putInt("position", position - 1);
                f.setArguments(args);
                return f;
            } else {
                return new NowFragment();
            }
        }

        @Override
        public int getCount() {
            return MySchedule.availableSchedules.size() + 1;
        }
    }
}
