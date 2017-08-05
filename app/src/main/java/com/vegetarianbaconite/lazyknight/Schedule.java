package com.vegetarianbaconite.lazyknight;

import org.joda.time.LocalTime;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static com.vegetarianbaconite.lazyknight.Schedule.ClassDay.FRIDAY;
import static com.vegetarianbaconite.lazyknight.Schedule.ClassDay.THURSDAY;
import static com.vegetarianbaconite.lazyknight.Schedule.ClassDay.TUESDAY;
import static com.vegetarianbaconite.lazyknight.Schedule.ClassDay.WEDNESDAY;

public class Schedule {
    Lecture COP3223H, EDF2005, IDH1920H, MAC2313H, SPC1603H;
    ClassDay days[] = new ClassDay[]{null, ClassDay.MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, null};
    List<Lecture> classes;
    private static Schedule s = null;

    public static Schedule getInstance() {
        if (s == null) s = new Schedule();
        return s;
    }

    private Schedule() {
        COP3223H = new Lecture("COP", 9, 30, 10, 20, ClassDay.MONDAY, ClassDay.WEDNESDAY, ClassDay.FRIDAY);
        EDF2005 = new Lecture("EDF", 10, 30, 13, 20, ClassDay.WEDNESDAY);
        IDH1920H = new Lecture("IDH", 16, 30, 18, 50, ClassDay.MONDAY);
        MAC2313H = new Lecture("MAC", 9, 0, 10, 50, TUESDAY, ClassDay.THURSDAY);
        SPC1603H = new Lecture("SPC", 12, 0, 13, 15, TUESDAY, ClassDay.THURSDAY);

        classes = Arrays.asList(COP3223H, EDF2005, IDH1920H, MAC2313H, SPC1603H);
    }

    public Lecture getCurrentClass() { //TODO: Test
        Calendar cal = Calendar.getInstance();
        LocalTime now = new LocalTime(cal);
        ClassDay day = getDay();

        for (Lecture l : classes) {
            try {
                if (now.isAfter(l.getStart(day)) && now.isBefore(l.getStart(day))) return l;
            } catch (IllegalArgumentException ignored) {
            }
        }

        return null;
    }

    public Lecture getNextClass() { //TODO: Test
        Calendar cal = Calendar.getInstance();
        LocalTime now = new LocalTime(cal);
        ClassDay day = getDay();
        Lecture next = null;

        for (Lecture l : classes) {
            try {
                if (now.isBefore(l.getStart(day)))
                    if (next == null || l.getStart(day).isBefore(next.getStart(day)))
                        next = l;
            } catch (IllegalArgumentException ignored) {
            }
        }

        return next;
    }

    ClassDay getDay() {
        Calendar cal = Calendar.getInstance();
        return days[cal.get(Calendar.DAY_OF_WEEK)];
    }

    LocalTime now() {
        Calendar cal = Calendar.getInstance();
        return new LocalTime(cal);
    }

    public enum ClassDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
    }
}
