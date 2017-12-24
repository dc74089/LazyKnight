package com.vegetarianbaconite.schedulelib;

import org.joda.time.LocalTime;

import java.util.Calendar;
import java.util.List;

import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.FRIDAY;
import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.MONDAY;
import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.THURSDAY;
import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.TUESDAY;
import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.WEDNESDAY;

public class ScheduleUtil {
    private final ClassDay days[] = new ClassDay[]{null, null, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, null};
    private List<Lecture> classes;
    private static ScheduleUtil s = null;

    public static ScheduleUtil getInstance() {
        if (s == null) s = new ScheduleUtil();
        return s;
    }

    private ScheduleUtil() {
        classes = MySchedule.currentSemester;
    }

    public Lecture getCurrentClass() {
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

    public Lecture getNextClass() {
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

    public ClassDay getDay() {
        Calendar cal = Calendar.getInstance();
        return days[cal.get(Calendar.DAY_OF_WEEK)];
    }

    public LocalTime now() {
        Calendar cal = Calendar.getInstance();
        return new LocalTime(cal);
    }

    public enum ClassDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    }
}
