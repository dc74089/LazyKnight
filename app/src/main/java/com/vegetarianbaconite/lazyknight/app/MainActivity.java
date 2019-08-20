package com.vegetarianbaconite.lazyknight.app;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.vegetarianbaconite.schedulelib.Lecture;
import com.vegetarianbaconite.schedulelib.Schedules;

import java.util.List;

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
                return new FriendNowFragment();
            }
        }

        @Override
        public int getCount() {
            return getSchedule().size() + 1;
        }
    }

    static List<List<Lecture>> getSchedule() {
        switch (BuildConfig.FLAVOR) {
            case "bacon":
                return Schedules.baconSchedules;
            case "dorm":
                return Schedules.dormSchedules;
            case "personal":
                return Schedules.personalSchedules;
        }
        throw new RuntimeException("Invalid build flavor");
    }

    static List<String> getNames() {
        switch (BuildConfig.FLAVOR) {
            case "bacon":
                return Schedules.baconNames;
            case "dorm":
                return Schedules.dormNames;
            case "personal":
                return Schedules.personalNames;
        }
        throw new RuntimeException("Invalid build flavor");
    }
}
