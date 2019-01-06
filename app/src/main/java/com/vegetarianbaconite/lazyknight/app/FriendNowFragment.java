package com.vegetarianbaconite.lazyknight.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vegetarianbaconite.schedulelib.Lecture;
import com.vegetarianbaconite.schedulelib.ScheduleUtil;

import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

import java.util.List;

public class FriendNowFragment extends Fragment {
    View root;
    List<List<Lecture>> scheduleList;
    List<String> nameList;
    String timePattern, dayTimePattern;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scheduleList = MainActivity.getSchedule();
        nameList = MainActivity.getNames();


        timePattern = DateFormat.is24HourFormat(getContext()) ? "HH:mm" : "KK:mm a";
        dayTimePattern = DateFormat.is24HourFormat(getContext()) ? "EEEE HH:mm" : "EEEE KK:mm a";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_friend_now, container, false);
        ViewGroup parentLayout = root.findViewById(R.id.fLinLay);

        ((TextView) root.findViewById(R.id.fCurrentTime)).setText(LocalDateTime.now().toString(dayTimePattern));

        for (int i = 0; i < scheduleList.size(); i++) {
            View singleFriend = inflater.inflate(R.layout.component_friend, parentLayout, false);
            ScheduleUtil util = new ScheduleUtil(scheduleList.get(i));

            ((TextView) singleFriend.findViewById(R.id.fName)).setText(nameList.get(i));
            if (util.getCurrentClass() != null) {
                Lecture currClass = util.getCurrentClass();
                ((TextView) singleFriend.findViewById(R.id.fActivity)).setText(currClass.getClassName());
                ((TextView) singleFriend.findViewById(R.id.fLocation)).setText(currClass.getRoom());
                ((TextView) singleFriend.findViewById(R.id.fDays)).setText(currClass.getDayString());

                LocalTime start = currClass.getStart();
                LocalTime end = currClass.getEnd();

                ((TextView) singleFriend.findViewById(R.id.fStart)).setText(start.toString(timePattern));
                ((TextView) singleFriend.findViewById(R.id.fEnd)).setText(end.toString(timePattern));
            } else {
                ((TextView) singleFriend.findViewById(R.id.fActivity)).setText("Free");
                ((TextView) singleFriend.findViewById(R.id.fLocation)).setText("");
                ((TextView) singleFriend.findViewById(R.id.fDays)).setText("");
                ((TextView) singleFriend.findViewById(R.id.fStart)).setText("Now");
                if (util.getNextClass() != null)
                    ((TextView) singleFriend.findViewById(R.id.fEnd)).setText(util.getNextClass().getStart().toString(timePattern));
                else
                    ((TextView) singleFriend.findViewById(R.id.fEnd)).setText("Tomorrow");
            }

            parentLayout.addView(singleFriend);
        }

        Log.d("Now", "Inflating friend fragment");
        return root;
    }
}
