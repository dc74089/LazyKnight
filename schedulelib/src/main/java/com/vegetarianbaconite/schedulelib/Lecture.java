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
    LocalTime startTime, endTime;
    private Map<ScheduleUtil.ClassDay, LocalTime> start = new HashMap<>();
    private Map<ScheduleUtil.ClassDay, LocalTime> end = new HashMap<>();

    public Lecture() {
    }

    public Lecture(String shortName, String className, String professor, String room, int startHour, int startMinute, int endHour, int endMinute, ScheduleUtil.ClassDay... days) {
        setShortName(shortName);
        setClassName(className);
        setProfessor(professor);
        setRoom(room);

        startString = String.format("%d:%02d", startHour, startMinute);
        endString = String.format("%d:%02d", endHour, endMinute);

        startTime = new LocalTime(startHour, startMinute);
        endTime = new LocalTime(endHour, endMinute);

        setDayString(days);

        for (ScheduleUtil.ClassDay day : days) {
            start.put(day, startTime);
            end.put(day, endTime);
        }
    }

    public int getTimeTillStart(ScheduleUtil.ClassDay day, LocalTime now) { //TODO: Test
        Period p = new Period(now, getStart(day));
        return Minutes.standardMinutesIn(p).getMinutes();
    }

    public int getProgressInClass(ScheduleUtil.ClassDay day, LocalTime now) { //TODO: Test
        Period p = new Period(getStart(day), now);
        return Minutes.standardMinutesIn(p).getMinutes();
    }

    public int getLength(ScheduleUtil.ClassDay day) { //TODO: Test
        Period p = new Period(getStart(day), getEnd(day));
        return Minutes.standardMinutesIn(p).getMinutes();
    }

    public int getTimeLeft(ScheduleUtil.ClassDay day, LocalTime now) {
        return getLength(day) - getProgressInClass(day, now);
    }

    public LocalTime getStart(ScheduleUtil.ClassDay day) {
        if (start.containsKey(day)) return start.get(day);
        return null;
    }

    public LocalTime getStart() {
        return startTime;
    }

    public LocalTime getEnd(ScheduleUtil.ClassDay day) {
        if (end.containsKey(day)) return end.get(day);
        return null;
    }

    public LocalTime getEnd() {
        return endTime;
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

    @Deprecated
    public String getStartString() {
        return startString;
    }

    public void setStartString(String startString) {
        this.startString = startString;
    }

    @Deprecated
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

    public void setDayString(ScheduleUtil.ClassDay[] days) {
        List<ScheduleUtil.ClassDay> dayList = Arrays.asList(days);
        this.dayString = "";

        if (dayList.contains(ScheduleUtil.ClassDay.MONDAY))
            dayString += "M";
        if (dayList.contains(ScheduleUtil.ClassDay.TUESDAY))
            dayString += "T";
        if (dayList.contains(ScheduleUtil.ClassDay.WEDNESDAY))
            dayString += "W";
        if (dayList.contains(ScheduleUtil.ClassDay.THURSDAY))
            dayString += "R";
        if (dayList.contains(ScheduleUtil.ClassDay.FRIDAY))
            dayString += "F";

    }
}
