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
    private ClassDay days[] = new ClassDay[]{null, null, ClassDay.MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, null};
    private List<Lecture> classes;
    private static Schedule s = null;

    public static Schedule getInstance() {
        if (s == null) s = new Schedule();
        return s;
    }

    private Schedule() {
        Lecture COP3223H = new Lecture("C", "H Intro to C", "Staff", "ENG1, O227",
                9, 30, 10, 20, ClassDay.MONDAY, ClassDay.WEDNESDAY, ClassDay.FRIDAY);
        Lecture EDF2005 = new Lecture("ED", "Intro to Teaching", "Philip Koger", "CB1, O309",
                10, 30, 13, 20, ClassDay.WEDNESDAY);
        Lecture IDH1920H = new Lecture("HON", "Honors Symposium", "Martin Dupuis", "CB1, O121\nNSC O209",
                16, 30, 18, 50, ClassDay.MONDAY);
        Lecture MAC2313H = new Lecture("CALC", "H Calculus 3", "Zhisheng Shuai", "MSB 0109",
                9, 0, 10, 50, TUESDAY, ClassDay.THURSDAY);
        Lecture SPC1603H = new Lecture("SPC", "H Fund Tech Pres", "George Musambira", "NSC O147",
                12, 0, 13, 15, TUESDAY, ClassDay.THURSDAY);

        classes = Arrays.asList(COP3223H, EDF2005, IDH1920H, MAC2313H, SPC1603H);
    }

    public Lecture getCurrentClass() { //TODO: Test
        Calendar cal = Calendar.getInstance();
        LocalTime now = new LocalTime(cal);
        ClassDay day = getDay();

        for (Lecture l : classes) {
            try {
                if (now.isAfter(l.getStart(day)) && now.isBefore(l.getEnd(day))) return l;
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
