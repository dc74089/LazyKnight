package com.vegetarianbaconite.lazyknight.wear;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vegetarianbaconite.schedulelib.Lecture;
import com.vegetarianbaconite.schedulelib.Schedules;

public class WearScheduleFragment extends Fragment {
    LinearLayout ll;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_class_info, container, false);

        Bundle args = getArguments();
        Lecture l = Schedules.currentSemester.get(args.getInt("position", 0));

        ll = root.findViewById(R.id.ciLinLay);

        ((TextView) ll.findViewById(R.id.ciClass)).setText(l.getShortName());
        ((TextView) ll.findViewById(R.id.ciName)).setText(l.getClassName());
        ((TextView) ll.findViewById(R.id.ciProfessor)).setText(l.getProfessor());
        ((TextView) ll.findViewById(R.id.ciRoom)).setText(l.getRoom());

        String timeString = String.format("%s %s - %s", l.getDayString(), l.getStartString(), l.getEndString());
        ((TextView) ll.findViewById(R.id.ciTimes)).setText(timeString);

        ll.findViewById(R.id.ciTimes).setVisibility(View.VISIBLE);

        return root;
    }
}
