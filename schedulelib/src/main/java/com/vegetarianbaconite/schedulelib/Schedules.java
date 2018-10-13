package com.vegetarianbaconite.schedulelib;

import java.util.Arrays;
import java.util.List;

import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.FRIDAY;
import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.MONDAY;
import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.THURSDAY;
import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.TUESDAY;
import static com.vegetarianbaconite.schedulelib.ScheduleUtil.ClassDay.WEDNESDAY;

public class Schedules {
    public static List<List<Lecture>> mySchedules = Arrays.asList(sophomoreFall(), sophomoreSpring(), freshmanSpring(), freshmanFall());
    public static List<String> myScheduleNames = Arrays.asList("Fall 2018", "Spring 2019", "Spring 2018", "Fall 2017");


    public static List<List<Lecture>> baconSchedules = Arrays.asList(sophomoreFall(), natFall2018(), ryanFall2018(), jenFall2018(), sebaFall2018());
    public static List<String> baconNames = Arrays.asList("Dominic", "Natalie", "Ryan", "Jen", "Seba");
    public static List<List<Lecture>> dormSchedules = Arrays.asList(sophomoreFall());
    public static List<String> dormNames = Arrays.asList("Dominic");
    public static List<List<Lecture>> personalSchedules = Arrays.asList(sophomoreFall(), natFall2018(), ryanFall2018(), jenFall2018(), sebaFall2018());
    public static List<String> personalNames = Arrays.asList("Dominic", "Natalie", "Ryan", "Jen", "Seba");

    public static final List<Lecture> currentSemester = sophomoreFall();

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
        Lecture BSC2010C_LAB = new Lecture("BSC 2010C", "Biology 1 Lab", "Elizabeth Perez", "TBA",
                8, 30, 10, 20, THURSDAY);
        Lecture CIS3360 = new Lecture("CIS 3360", "Security in Computing", "Shelly Bard", "Online",
                00, 00, 00, 00);
        Lecture COP3503 = new Lecture("COP 3503H", "H Computer Science 2", "Joseph LaViola", "BHC 131",
                11, 30, 12, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture EDF2085 = new Lecture("EDF 2085", "Intro to Diversity", "Karen Biraimah", "TA 221",
                13, 30, 16, 20, TUESDAY);
        Lecture MUL2010 = new Lecture("MUL 2010", "Enjoyment of Music", "Joe Gennaro", "Online",
                00, 00, 00, 00);
        Lecture FLL = new Lecture("FLL", "FLL Team Practice", "", "Lake Highland",
                15, 15, 17, 00, MONDAY, WEDNESDAY);
        Lecture aftercare = new Lecture("AC", "Aftercare", "", "Lake Highland",
                15, 15, 17, 00, FRIDAY);

        return Arrays.asList(BSC2010C, BSC2010C_LAB, CIS3360, COP3503, EDF2085, MUL2010, FLL, aftercare);
    }

    public static List<Lecture> sophomoreSpring() {
        Lecture CDA3013C = new Lecture("CDA 3103C", "Logic & Organization", "TBA", "PSY 108",
                9, 00, 10, 15, TUESDAY, THURSDAY);
        Lecture CDA3103C_LAB = new Lecture("CDA 3103C", "Logic & Organization Lab", "TBA", "HPA1 106",
                10, 30, 11, 20, FRIDAY);
        Lecture COP4331 = new Lecture("COP 4331", "Proc. Object Oriented", "TBA", "ENG2 102",
                12, 00, 13, 15, MONDAY, WEDNESDAY);
        Lecture COP4331_LAB = new Lecture("COP 4331", "Proc. Object Oriented Lab", "TBA", "CB1 309",
                17, 00, 17, 50, TUESDAY);
        Lecture COT4210 = new Lecture("COT4210", "Discrete II", "TBA", "ENG2 102",
                12, 00, 13, 15, TUESDAY, THURSDAY);
        Lecture EDF4603 = new Lecture("EDF 4603", "Ethical, Legal, Safety", "TBA", "TA 202",
                13, 30, 16, 20, THURSDAY);
        Lecture LIT3930H = new Lecture("LIT 3930H", "Harry Potter & Youth Culture", "William Pugh", "BHC 126",
                10, 30, 11, 45, TUESDAY, THURSDAY);

        return Arrays.asList(CDA3013C, CDA3103C_LAB, COP4331, COP4331_LAB, COT4210, EDF4603, LIT3930H);
    }

    public static List<Lecture> jenFall2018() {
        Lecture COP3223H = new Lecture("COP 3223H", "H Intro to C", "", "BHC 131",
                10, 30, 11, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture EGS1006 = new Lecture("EGS 1006", "Intro to Engineering", "", "CB2 101",
                9, 30, 10, 20, FRIDAY);
        Lecture EGS1006Lab = new Lecture("EGS 1006", "Intro to Engineering Lab", "", "ENG1 260",
                13, 30, 14, 50, WEDNESDAY);
        Lecture IDH1920H = new Lecture("IDH 1920H", "Honors Symposium", "", "NSC 101",
                16, 30, 18, 50, MONDAY);
        Lecture MAC2311H = new Lecture("MAC 2311H", "H Calculus 1", "", "MSB 121",
                15, 30, 17, 20, TUESDAY, THURSDAY);
        Lecture PEM2104 = new Lecture("PEM 2104", "Personal Fitness", "", "TA 322",
                10, 30, 13, 20, TUESDAY);
        return Arrays.asList(COP3223H, EGS1006, EGS1006Lab, IDH1920H, MAC2311H, PEM2104);
    }

    public static List<Lecture> natFall2018() {
        Lecture COP3223H = new Lecture("COP 3223H", "H Intro to C", "", "BHC 131",
                12, 30, 13, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture MAC2313 = new Lecture("MAC 2313", "Calc 3", "", "MSB 121",
                13, 30, 14, 10, MONDAY, WEDNESDAY, TUESDAY, THURSDAY);
        Lecture EGS1006 = new Lecture("EGS 1006", "Intro to Engineering", "", "CB2 101",
                10, 30, 11, 20, FRIDAY);
        Lecture EGS1006Lab = new Lecture("EGS 1006", "Intro to Engineering Lab", "", "ENG1 260",
                12, 00, 13, 20, THURSDAY);
        Lecture IDH1920H = new Lecture("IDH 1920H", "Honors Symposium", "", "NSC 101",
                16, 30, 18, 50, TUESDAY);
        Lecture MUN3113 = new Lecture("MUN 3113", "Marching Band", "", "N/A",
                18, 00, 20, 30, MONDAY, WEDNESDAY, FRIDAY);
        Lecture colorGuard = new Lecture("CG-Sec", "Colorguard Sectional", "", "N/A",
                17, 00, 18, 00, MONDAY, WEDNESDAY);
        return Arrays.asList(COP3223H, MAC2313, EGS1006, EGS1006Lab, IDH1920H, MUN3113, colorGuard);
    }

    public static List<Lecture> ryanFall2018() {
        Lecture MAC2312 = new Lecture("MAC 2312", "Calc 2", "", "MSB 121",
                9, 30, 10, 20, MONDAY, TUESDAY, WEDNESDAY, THURSDAY);
        Lecture COP3223 = new Lecture("COP 3223C", "Intro to C", "", "CB1 104",
                10, 30, 11, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture AMH2010 = new Lecture("AMH 2010", "US History", "", "BA1 119",
                11, 30, 12, 20, MONDAY, WEDNESDAY);
        Lecture BSC2010 = new Lecture("BSC 2010C", "Biology 1", "", "CB2 201",
                12, 30, 13, 20, MONDAY, WEDNESDAY, FRIDAY);
        return Arrays.asList(MAC2312, COP3223, AMH2010, BSC2010);
    }

    public static List<Lecture> sebaFall2018() {
        Lecture MAC2313 = new Lecture("MAC 2313", "Calc 2", "", "MSB 406",
                7, 30, 8, 20, MONDAY, TUESDAY, WEDNESDAY, THURSDAY);
        Lecture CHM2045 = new Lecture("CHM 2045C", "Chem 1", "", "CB2 106",
                9, 30, 10, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture CHM2045Disc = new Lecture("CHM 2045", "Chem 1 Discusion", "", "BA1 110",
                15, 30, 16, 20, THURSDAY);
        Lecture EGN3310 = new Lecture("EGN 3310", "Statics", "", "HPA1 119",
                13, 30, 14, 45, MONDAY, WEDNESDAY);
        Lecture EGS1006 = new Lecture("EGS 1006", "Intro to Engineering", "", "CB2 101",
                8, 30, 9, 20, FRIDAY);
        Lecture EGS1006Lab = new Lecture("EGS 1006", "Intro to Engineering Lab", "", "ENG1 260",
                15, 00, 16, 20, TUESDAY);
        return Arrays.asList(MAC2313, CHM2045, CHM2045Disc, EGN3310, EGS1006, EGS1006Lab);
    }
}
