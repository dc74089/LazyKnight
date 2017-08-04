package com.vegetarianbaconite.lazyknight;

import org.joda.time.LocalTime;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Lecture {
    String className;
    private Map<Schedule.ClassDay, LocalTime> start = new HashMap<>();
    private Map<Schedule.ClassDay, LocalTime> end = new HashMap<>();

    public Lecture(){};

    public Lecture(String name, int startHour, int startMinute, int endHour, int endMinute, Schedule.ClassDay... days) {
        setClassName(name);
        for (Schedule.ClassDay day : days) {
            start.put(day, new LocalTime(startHour, startMinute));
            end.put(day, new LocalTime(endHour, endMinute));
        }
    }

    public LocalTime getStart(Schedule.ClassDay day){
        if(start.containsKey(day)) return start.get(day);
        return null;
    }

    public LocalTime getEnd(Schedule.ClassDay day) {
        if (end.containsKey(day)) return end.get(day);
        return null;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
