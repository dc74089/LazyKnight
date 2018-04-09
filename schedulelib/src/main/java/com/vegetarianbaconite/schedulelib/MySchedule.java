package com.vegetarianbaconite.schedulelib;

import java.util.Arrays;
import java.util.List;

import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.FRIDAY;
import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.MONDAY;
import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.THURSDAY;
import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.TUESDAY;
import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.WEDNESDAY;

public class MySchedule {
    public static List<List<Lecture>> availableSchedules = Arrays.asList(sophomoreFall(), freshmanSpring(), freshmanFall());
    public static List<String> scheduleNames = Arrays.asList("Fall 2018", "Spring 2018", "Fall 2017");

    public static final List<Lecture> currentSemester = freshmanSpring();

    public static List<Lecture> freshmanFall() {
        Lecture COP3223H = new Lecture("COP 3223H", "H Intro to Prog w/ C", "Glenn Martin", "ENG1 227",
                9, 30, 10, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture EDF2005 = new Lecture("EDF 2005", "Intro to Teaching Prof", "Philip Koger", "CB1 309",
                10, 30, 13, 20, WEDNESDAY);
        Lecture IDH1920H = new Lecture("IDH 1920H", "Honors Symposium", "Reilly Dearth", "CB1 121\nNSC 209",
                16, 30, 18, 50, MONDAY);
        Lecture MAC2313H = new Lecture("MAC 2313H", "H Calculus 3", "Zhisheng Shuai", "MSB 109",
                9, 0, 10, 50, TUESDAY, THURSDAY);
        Lecture SPC1603H = new Lecture("SPC 1603H", "H Fund Tech Pres", "George Musambira", "NSC 147",
                12, 0, 13, 15, TUESDAY, THURSDAY);

        return Arrays.asList(COP3223H, EDF2005, IDH1920H, MAC2313H, SPC1603H);
    }

    public static List<Lecture> freshmanSpring() {
        Lecture COP3502H = new Lecture("COP 3502H", "H Computer Science 1", "Sean Szumlanski", "BA1 209",
                9, 00, 10, 15, TUESDAY, THURSDAY);
        Lecture COT3100H = new Lecture("COT 3100H", "H Intro to Discrete", "Wei Zhang", "ENG1 383",
                9, 00, 10, 15, MONDAY, WEDNESDAY);
        Lecture EME2040 = new Lecture("EME 2040", "Intro to Tech for Ed", "Richard Thripp", "TA 303",
                10, 30, 13, 20, MONDAY);
        Lecture ENC1102H = new Lecture("ENC 1002H", "H Composition 2", "Kevin Roozen", "BHC 128",
                12, 00, 13, 15, TUESDAY, THURSDAY);
        Lecture COP3330 = new Lecture("COP 3330", "Intro to OOP", "Michelle Farahbaksh", "Online",
                00, 00, 00, 00);

        return Arrays.asList(COP3502H, COT3100H, EME2040, ENC1102H, COP3330);
    }

    public static List<Lecture> sophomoreFall() {
        Lecture BSC2010C = new Lecture("BSC 2010C", "Biology 1", "Pamela Thomas", "CB2 201",
                12, 30, 13, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture BSC2010C_LAB = new Lecture("BSC 2010C", "Biology 1 Lab", "Karen Yeargain", "TBA",
                8, 30, 10, 20, THURSDAY);
        Lecture CIS3360 = new Lecture("CIS 3360", "Security in Computing", "Demitrios Glinos", "Online",
                00, 00, 00, 00);
        Lecture COP3503 = new Lecture("COP 3503H", "H Computer Science 2", "Staff", "BHC 131",
                11, 30, 12, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture EDF2085 = new Lecture("EDF 20185", "Intro to Diversity", "Staff", "TA 221",
                13, 30, 16, 20, TUESDAY);
        Lecture MUL2010 = new Lecture("MUL 2010", "Enjoyment of Music", "Robert Gennaro", "Online",
                00, 00, 00, 00);

        return Arrays.asList(BSC2010C, BSC2010C_LAB, CIS3360, COP3503, EDF2085, MUL2010);
    }

    public static List<Lecture> sophomoreSpring() {
        Lecture CDA3013C = new Lecture("CDA 3103C", "Logic & Organization", "TBA", "PSY 108",
                9, 00, 10, 15, TUESDAY, THURSDAY);
        Lecture CDA3103C_LAB = new Lecture("CDA 3103C", "Logic & Organization Lab", "TBA", "HPA1 106",
                10, 30, 11, 20, FRIDAY);
        Lecture LIT3930H = new Lecture("LIT 3930H", "Harry Potter & Youth Culture", "William Pugh", "BHC 126",
                10, 30, 11, 45, TUESDAY, THURSDAY);

        return Arrays.asList(CDA3013C, CDA3103C_LAB, LIT3930H);
    }
}
