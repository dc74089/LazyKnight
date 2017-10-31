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
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class NowFragment extends Fragment implements View.OnClickListener {
    View root;
    TextView now, until;

    Schedule s;
    Lecture current;
    int state; //0 = blank, 1 = next, 2 = current

    final DateTimeFormatter df = DateTimeFormat.forPattern("E HH:mm");

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        s = Schedule.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        current = s.getCurrentClass();
        state = 2;

        if (current != null && current.getTimeLeft(s.getDay(), new LocalTime()) < 30) {
            Lecture next = s.getNextClass();

            if (next.getTimeTillStart(s.getDay(), new LocalTime()) < 30) {
                current = next;
                state = 1;
            }
        } else if (current == null) {
            current = s.getNextClass();
            state = 1;
        }

        if (current != null) {
            root = inflater.inflate(R.layout.fragment_now, container, false);
            root.setClickable(true);
            root.setOnClickListener(this);

            now = root.findViewById(R.id.nCurrentTime);
            until = root.findViewById(R.id.nUntil);

            ((TextView) root.findViewById(R.id.nCode)).setText(current.getShortName());
            ((TextView) root.findViewById(R.id.nName)).setText(current.getClassName());
            ((TextView) root.findViewById(R.id.nProf)).setText(current.getProfessor());
            ((TextView) root.findViewById(R.id.nRoom)).setText(current.getRoom());
            ((TextView) root.findViewById(R.id.nStart)).setText(current.getStartString());
            ((TextView) root.findViewById(R.id.nEnd)).setText(current.getEndString());

            Log.d("Now", "Inflating fragment_now");
            update();
            return root;
        }

        Log.d("Now", "Inflating fragment_blank");
        state = 0;
        update();
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    private void update() {
        now.setText(df.print(new LocalDateTime()));

        switch (state) {
            case 1:
                until.setVisibility(View.VISIBLE);
                until.setText(String.format("%d minutes until start",
                        current.getTimeTillStart(s.getDay(), new LocalTime())));
                break;
            case 2:
                until.setVisibility(View.VISIBLE);
                until.setText(String.format("%d minutes left",
                        current.getTimeLeft(s.getDay(), new LocalTime())));
                break;
            default:
                until.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        update();
    }
}
