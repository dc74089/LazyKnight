package com.vegetarianbaconite.lazyknight.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vegetarianbaconite.schedulelib.Lecture;
import com.vegetarianbaconite.schedulelib.Schedule;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class NowFragment extends Fragment {
    View root;
    final DateTimeFormatter df = DateTimeFormat.forPattern("E HH:mm");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Lecture current = Schedule.getInstance().getCurrentClass();
        if (current == null) current = Schedule.getInstance().getNextClass();

        if (current != null) {
            root = inflater.inflate(R.layout.fragment_now, container, false);

            ((TextView) root.findViewById(R.id.nCurrentTime)).setText(df.print(new LocalDateTime()));

            ((TextView) root.findViewById(R.id.nCode)).setText(current.getShortName());
            ((TextView) root.findViewById(R.id.nName)).setText(current.getClassName());
            ((TextView) root.findViewById(R.id.nProf)).setText(current.getProfessor());
            ((TextView) root.findViewById(R.id.nRoom)).setText(current.getRoom());
            ((TextView) root.findViewById(R.id.nStart)).setText(current.getStartString());
            ((TextView) root.findViewById(R.id.nEnd)).setText(current.getEndString());

            Log.d("Now", "Inflating fragment_now");
            return root;
        }

        Log.d("Now", "Inflating fragment_blank");
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
}
