package com.vegetarianbaconite.lazyknight.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vegetarianbaconite.schedulelib.Lecture;
import com.vegetarianbaconite.schedulelib.ScheduleUtil;

import org.joda.time.LocalTime;

import java.util.List;

public class ScheduleFragment extends Fragment {
    LinearLayout ll;
    LayoutInflater llInflater;
    ScheduleUtil util;
    String timePattern;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d("Frag", "Fragment Created");
        Bundle args = getArguments();
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        List<Lecture> s = MainActivity.getSchedule().get(args.getInt("position", 0));

        ((TextView) root.findViewById(R.id.fSemester)).setText(MainActivity.getNames().
                get(args.getInt("position", 0)));

        ll = root.findViewById(R.id.fLinLay);
        llInflater = getLayoutInflater();

        util = new ScheduleUtil(s);
        timePattern = DateFormat.is24HourFormat(getContext()) ? "HH:mm" : "KK:mm a";

        for (Lecture l : s)
            inflateForLecture(l);

        return root;
    }

    private void inflateForLecture(Lecture l) {
        Log.d("Frag", "Inflating lecture");

        View component = llInflater.inflate(R.layout.component_lecture, ll, false);

        ((TextView) component.findViewById(R.id.sCode)).setText(l.getShortName());
        ((TextView) component.findViewById(R.id.sName)).setText(l.getClassName());
        ((TextView) component.findViewById(R.id.sProf)).setText(l.getProfessor());
        ((TextView) component.findViewById(R.id.sRoom)).setText(l.getRoom());

        ((TextView) component.findViewById(R.id.sDays)).setText(l.getDayString());

        LocalTime start = l.getStart();
        LocalTime end = l.getEnd();

        ((TextView) component.findViewById(R.id.sStart)).setText(start.toString(timePattern));
        ((TextView) component.findViewById(R.id.sEnd)).setText(end.toString(timePattern));

        ll.addView(component);
    }
}
