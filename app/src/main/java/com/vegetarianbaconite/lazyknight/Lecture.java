package com.vegetarianbaconite.lazyknight;

import org.joda.time.LocalTime;

public class Lecture {
    String className;
    LocalTime monStart, monEnd;
    LocalTime tuesStart, tuesEnd;
    LocalTime wedStart, wedEnd;
    LocalTime thursStart, thursEnd;
    LocalTime friStart, friEnd;

    public LocalTime getStart(ClassDay day){
        switch (day) {
            case MONDAY:
                return monStart;
            case TUESDAY:
                return tuesStart;
            case WEDNESDAY:
                return wedStart;
            case THURSDAY:
                return thursStart;
            case FRIDAY:
                return friStart;
            default:
                return null;
        }
    }

    public LocalTime getEnd(ClassDay day) {
        switch (day) {
            case MONDAY:
                return monEnd;
            case TUESDAY:
                return tuesEnd;
            case WEDNESDAY:
                return wedEnd;
            case THURSDAY:
                return thursEnd;
            case FRIDAY:
                return friEnd;
            default:
                return null;
        }
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMonStart(LocalTime monStart) {
        this.monStart = monStart;
    }

    public void setMonEnd(LocalTime monEnd) {
        this.monEnd = monEnd;
    }

    public void setTuesStart(LocalTime tuesStart) {
        this.tuesStart = tuesStart;
    }

    public void setTuesEnd(LocalTime tuesEnd) {
        this.tuesEnd = tuesEnd;
    }

    public void setWedStart(LocalTime wedStart) {
        this.wedStart = wedStart;
    }

    public void setWedEnd(LocalTime wedEnd) {
        this.wedEnd = wedEnd;
    }

    public void setThursStart(LocalTime thursStart) {
        this.thursStart = thursStart;
    }

    public void setThursEnd(LocalTime thursEnd) {
        this.thursEnd = thursEnd;
    }

    public void setFriStart(LocalTime friStart) {
        this.friStart = friStart;
    }

    public void setFriEnd(LocalTime friEnd) {
        this.friEnd = friEnd;
    }

    public enum ClassDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    }
}
