package com.vegetarianbaconite.schedulelib;

import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import org.joda.time.Period;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lecture {
    String shortName, className, professor, room;
    String startString, endString;
    String dayString = "";
    private Map<Schedule.ClassDay, LocalTime> start = new HashMap<>();
    private Map<Schedule.ClassDay, LocalTime> end = new HashMap<>();

    public Lecture() {
    }

    public Lecture(String shortName, String className, String professor, String room, int startHour, int startMinute, int endHour, int endMinute, Schedule.ClassDay... days) {
        setShortName(shortName);
        setClassName(className);
        setProfessor(professor);
        setRoom(room);

        startString = String.format("%d:%02d", startHour, startMinute);
        endString = String.format("%d:%02d", endHour, endMinute);

        setDayString(days);

        for (Schedule.ClassDay day : days) {
            start.put(day, new LocalTime(startHour, startMinute));
            end.put(day, new LocalTime(endHour, endMinute));
        }
    }

    public int getTimeTillStart(Schedule.ClassDay day, LocalTime now) { //TODO: Test
        Period p = new Period(now, getStart(day));
        return Minutes.standardMinutesIn(p).getMinutes();
    }

    public int getProgressInClass(Schedule.ClassDay day, LocalTime now) { //TODO: Test
        Period p = new Period(getStart(day), now);
        return Minutes.standardMinutesIn(p).getMinutes();
    }

    public int getLength(Schedule.ClassDay day) { //TODO: Test
        Period p = new Period(getStart(day), getEnd(day));
        return Minutes.standardMinutesIn(p).getMinutes();
    }

    public LocalTime getStart(Schedule.ClassDay day) {
        if (start.containsKey(day)) return start.get(day);
        return null;
    }

    public LocalTime getEnd(Schedule.ClassDay day) {
        if (end.containsKey(day)) return end.get(day);
        return null;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStartString() {
        return startString;
    }

    public void setStartString(String startString) {
        this.startString = startString;
    }

    public String getEndString() {
        return endString;
    }

    public void setEndString(String endString) {
        this.endString = endString;
    }

    public String getDayString() {
        return dayString;
    }

    public void setDayString(String dayString) {
        this.dayString = dayString;
    }

    public void setDayString(Schedule.ClassDay[] days) {
        List<Schedule.ClassDay> dayList = Arrays.asList(days);
        this.dayString = "";

        if (dayList.contains(Schedule.ClassDay.MONDAY))
            dayString += "M";
        if (dayList.contains(Schedule.ClassDay.TUESDAY))
            dayString += "T";
        if (dayList.contains(Schedule.ClassDay.WEDNESDAY))
            dayString += "W";
        if (dayList.contains(Schedule.ClassDay.THURSDAY))
            dayString += "R";
        if (dayList.contains(Schedule.ClassDay.FRIDAY))
            dayString += "F";

    }
}
