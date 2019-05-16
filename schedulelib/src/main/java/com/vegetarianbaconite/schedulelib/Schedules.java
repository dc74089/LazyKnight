package com.vegetarianbaconite.schedulelib;

import java.nio.file.AtomicMoveNotSupportedException;
import java.util.ArrayList;
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

    public static final List<Lecture> nullSchedule = new ArrayList<>();

    public static List<List<Lecture>> baconSchedules = Arrays.asList(nullSchedule, natSummer2019(), ryanSummer2019(), jenSummer2019(), nullSchedule, nullSchedule);
    public static List<String> baconNames = Arrays.asList("Dominic", "Natalie", "Ryan", "Jen", "Seba", "Alexis");
    public static List<List<Lecture>> dormSchedules = Arrays.asList(stevenSpring2019(), winstonSpring2019(), sophomoreSpring(), andrewSpring2019());
    public static List<String> dormNames = Arrays.asList("Steven", "Winston", "Dominic", "Andrew");
    public static List<List<Lecture>> personalSchedules = Arrays.asList(sophomoreSpring(), natSpring2019(), ryanSpring2019(), jenSpring2019(), sebaSpring2019(), alexisSpring2019(), stevenSpring2019(), winstonSpring2019(), andrewSpring2019());
    public static List<String> personalNames = Arrays.asList("Dominic", "Natalie", "Ryan", "Jen", "Seba", "Alexis", "Steven", "Winston", "Andrew");

    public static final List<Lecture> currentSemester = sophomoreSpring();

    /* Mine */
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
        Lecture CDA3013C = new Lecture("CDA 3103C", "Logic & Organization", "Sarah Angell", "PSY 108",
                9, 00, 10, 15, TUESDAY, THURSDAY);
        Lecture CDA3103C_LAB = new Lecture("CDA 3103C", "Logic & Organization Lab", "Sarah Angell", "HPA1 106",
                10, 30, 11, 20, FRIDAY);
        Lecture COP4331 = new Lecture("COP 4331", "Proc. Object Oriented", "Richard Leinecker", "ENG2 102",
                12, 00, 13, 15, MONDAY, WEDNESDAY);
        Lecture COP4331_LAB = new Lecture("COP 4331", "Proc. Object Oriented Lab", "Richard Leinecker", "CB1 309",
                17, 00, 17, 50, TUESDAY);
        Lecture COT4210 = new Lecture("COT4210", "Discrete II", "TBA", "ENG2 102",
                12, 00, 13, 15, TUESDAY, THURSDAY);
        Lecture EDF4603 = new Lecture("EDF 4603", "Ethical, Legal, Safety", "Randall Hewitt", "TA 202",
                13, 30, 16, 20, THURSDAY);
        Lecture EDF4467 = new Lecture("EDF 4467", "Learning Theory & Assessment", "Lindsey Jackson", "Online",
                00, 00, 00, 00);
        Lecture RED4043 = new Lecture("RED 4043", "Content Reading K-12", "Tammy Stafford", "Online",
                00, 00, 00, 00);
        Lecture FLL = new Lecture("FLL", "FLL Team Practice", "", "Lake Highland",
                15, 15, 17, 00, MONDAY, WEDNESDAY);
        Lecture aftercare = new Lecture("AC", "Aftercare", "", "Lake Highland",
                15, 15, 17, 00, FRIDAY);

        return Arrays.asList(CDA3013C, CDA3103C_LAB, COP4331, COP4331_LAB, COT4210, EDF4603, EDF4467, RED4043, FLL, aftercare);
    }

    /* Fall 2018 */
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

    /* Spring 2019 */
    public static List<Lecture> jenSpring2019() {
        Lecture COP3502H = new Lecture("COP 3502H", "Honors CS 1", "", "HEC 110",
                13, 30, 14, 35, MONDAY, WEDNESDAY);
        Lecture COT3100 = new Lecture("COT 3100", "Intro to Discrete", "", "ENG1 383",
                13, 30, 14, 45, TUESDAY, THURSDAY);
        Lecture MAC2312H = new Lecture("MAC 2312H", "Honors Calc 2", "", "MSB 121",
                9, 00, 10, 50, MONDAY, WEDNESDAY);
        Lecture PHY2048 = new Lecture("PHY 2048C", "Physics 1", "", "MSB 260",
                12, 30, 13, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture PHY2048_LAB = new Lecture("PHY 2048C", "Physics 1 Lab", "", "MSB 339",
                7, 30, 10, 20, THURSDAY);

        return Arrays.asList(COP3502H, COT3100, MAC2312H, PHY2048, PHY2048_LAB);
    }

    public static List<Lecture> natSpring2019() {
        Lecture EGN3211 = new Lecture("EGN 3211", "Engineering Analysis", "TBA", "ENG2 302",
                12, 00, 13, 15, MONDAY, WEDNESDAY);
        Lecture MAP2302H = new Lecture("MAP 2302H", "Honors Differential Equations", "TBA", "MSB 121",
                13, 30, 14, 50, TUESDAY, THURSDAY);
        Lecture SPC1603H = new Lecture("SPC 1603H", "Honors Technical Presentations", "Regina Francies", "BHC",
                15, 00, 16, 15, TUESDAY, THURSDAY);
        Lecture EGN1007 = new Lecture("EGN 1007", "Intro to Engineering", "Jacqueline Sullivan", "ENG1 260",
                15, 30, 16, 50, WEDNESDAY);
        Lecture EGN1007_LAB = new Lecture("EGN 1007", "Intro to Engineering Lab", "TBA", "CB2 201",
                10, 30, 11, 20);
        Lecture CHM2045C = new Lecture("CHM 2045C", "Chemistry 1", "", "CSB 101",
                12, 30, 13, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture CHM2045C_LAB = new Lecture("CHM 2045C", "Chemistry 1 Lab", "", "PSY 106",
                12, 30, 13, 20, TUESDAY);

        return Arrays.asList(EGN3211, MAP2302H, SPC1603H, EGN1007, EGN1007_LAB, CHM2045C, CHM2045C_LAB);
    }

    public static List<Lecture> ryanSpring2019() {
        Lecture COP3502C = new Lecture("COP 3502C", "Computer Science 1", "Sean Szumlanski", "CB1 121",
                11, 30, 12, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture COP3502C_LAB = new Lecture("COP 3502C", "Computer Science 1 Lab", "Sean Szumlanski", "ENG2 205",
                14, 30, 15, 20, FRIDAY);
        Lecture CIS3360 = new Lecture("CIS 3360", "Security in Computing", "TBA", "CB2 106",
                13, 30, 14, 45, MONDAY, WEDNESDAY);
        Lecture COT3100 = new Lecture("COT 3100", "Intro to Discrete", "", "CB2 101",
                15, 00, 16, 15, TUESDAY, THURSDAY);
        Lecture COT3100_LAB = new Lecture("COT 3100", "Intro to Discrete Lab", "", "CB2 109",
                15, 30, 16, 20, FRIDAY);
        Lecture CHM2045C = new Lecture("CHM 2045C", "Chemistry 1", "", "CSB 101",
                12, 30, 13, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture CHM2045C_LAB = new Lecture("CHM 2045C", "Chemistry 1 Lab", "", "PSY 106",
                12, 30, 13, 20, TUESDAY);

        return Arrays.asList(COP3502C, COP3502C_LAB, CIS3360, COT3100, COT3100_LAB, CHM2045C, CHM2045C_LAB);
    }

    public static List<Lecture> sebaSpring2019() {
        Lecture CHM2046 = new Lecture("CHM 2046", "Chemistry 2", "TBA", "VAB 132",
                9, 30, 10, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture MAP2302 = new Lecture("MAP 2302", "Ordinary Diff Eq", "TBA", "MSB 121",
                9, 00, 10, 20, TUESDAY, THURSDAY);
        Lecture EGN3343 = new Lecture("EGN 3343", "Thermodynamics", "TBA", "HEC 125",
                10, 30, 11, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture COP3502 = new Lecture("COP 3502", "Computer Science 1", "TBA", "ENG2 205",
                11, 30, 12, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture COP3502_LAB = new Lecture("COP 2502", "Computer Science 1 Lab", "TBA", "",
                14, 30, 15, 20, FRIDAY);
        Lecture COT3100 = new Lecture("COT 3100H", "H Intro to Discrete", "TBA", "ENG1 383",
                13, 30, 14, 45, TUESDAY, THURSDAY);
        Lecture EGN1007 = new Lecture("EGN 1007", "Intro to Engineering", "Jacqueline Sullivan", "CB2 201",
                13, 30, 14, 50, WEDNESDAY);
        Lecture EGN1007_LAB = new Lecture("EGN 1007", "Intro to Engineering Lab", "TBA", "ENG1 260",
                8, 30, 9, 20);

        return Arrays.asList(CHM2046, MAP2302, EGN3343, EGN1007, EGN1007_LAB, COP3502, COP3502_LAB, COT3100);
    }

    public static List<Lecture> alexisSpring2019() {
        Lecture EGN3365 = new Lecture("EGN 3365", "Properties of Materials", "", "ENG2 102",
                10, 30, 11, 45, MONDAY, WEDNESDAY);
        Lecture STA3032 = new Lecture("STA 3032", "Statistics for Engineers", "", "Online",
                0, 0, 0, 0);

        return Arrays.asList(EGN3365, STA3032);
    }

    public static List<Lecture> winstonSpring2019() {
        Lecture CHM2211 = new Lecture("CHM 2211", "Organic Chem 2", "TBA", "CB2 206",
                9, 30, 10, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture CHM2211L = new Lecture("CHM 2211", "Organic Lab Techniques", "TBA", "CHEM 202",
                13, 30, 16, 20, MONDAY);
        Lecture CHM2211L2 = new Lecture("CHM 2211", "Organic Lab Techniques", "TBA", "BA1 119",
                14, 00, 14, 50, FRIDAY);
        Lecture MAC2313 = new Lecture("MAC 2313", "Calculus 3", "TBA", "MSB 108",
                7, 30, 8, 20, MONDAY, TUESDAY, WEDNESDAY, THURSDAY);
        Lecture PCB3063 = new Lecture("PCB 3603", "Genetics", "TBA", "CB2 101",
                11, 30, 12, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture PHY2049 = new Lecture("PHY 2049", "Physics 2 Honors", "TBA", "BA1 115",
                9, 30, 10, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture PHY2049_LAB = new Lecture("PHY 2049", "Physics 2 Honors Lab", "TBA", "MSB 338",
                16, 30, 19, 20, THURSDAY);

        return Arrays.asList(CHM2211, CHM2211L, CHM2211L2, MAC2313, PCB3063, PHY2049, PHY2049_LAB);
    }

    public static List<Lecture> andrewSpring2019() {
        Lecture BSC1005 = new Lecture("BSC 1005", "Biological Principles", "", "CB1 121",
                13, 30, 14, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture CWR3201 = new Lecture("CWR 3201", "Engineering Fluid Mechanics", "", "CB1 307",
                13, 30, 14, 45, TUESDAY, THURSDAY);
        Lecture EGN3343 = new Lecture("EGN 3343", "Thermodynamics", "", "HEC 125",
                10, 30, 11, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture PHY2049 = new Lecture("PHY 2049", "Physics 2 Honors", "TBA", "BA1 115",
                9, 30, 10, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture PHY2049_LAB = new Lecture("PHY 2049", "Physics 2 Honors Lab", "TBA", "MSB 338",
                16, 30, 19, 20, THURSDAY);

        return Arrays.asList(BSC1005, CWR3201, EGN3343, PHY2049, PHY2049_LAB);
    }

    public static List<Lecture> stevenSpring2019() {
        Lecture CHM2210 = new Lecture("CHM 2210", "Organic Chem 1", "", "CB2 207",
                18, 00, 19, 15, TUESDAY, THURSDAY);
        Lecture MAC1140 = new Lecture("MAC 1140", "Pre-Calculus", "", "CB2 201",
                10, 30, 11, 20, MONDAY, WEDNESDAY);
        Lecture PCB3063 = new Lecture("PCB 3603", "Genetics", "TBA", "CB2 101",
                11, 30, 12, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture PHY2054 = new Lecture("PHY 2054", "College Physics 2", "", "MSB 260",
                14, 30, 15, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture PHY2054_LAB = new Lecture("PHY 2054", "College Physics 2 Lab", "", "MSB 337",
                7, 30, 10, 20, THURSDAY);

        return Arrays.asList(CHM2210, MAC1140, PCB3063, PHY2054, PHY2054_LAB);
    }

    public static List<Lecture> jenSummer2019() {
        Lecture MAS3105 = new Lecture("MAS 3105", "Matrix and Linear", "", "MSB 121",
                9, 00, 10, 50, MONDAY, TUESDAY, WEDNESDAY, THURSDAY);

        return Arrays.asList(MAS3105);
    }

    public static List<Lecture> natSummer2019() {
        Lecture JPN1120C = new Lecture("JPN 1120C", "Elementary Japanese", "", "NSC 112",
                10, 00, 11, 50, MONDAY, WEDNESDAY);

        return Arrays.asList(JPN1120C);
    }

    public static List<Lecture> ryanSummer2019() {
        Lecture CDA3103C = new Lecture("CDA 3103C", "Computer Logic & Org", "", "HPA1 119",
                14, 00, 15, 50, MONDAY, WEDNESDAY);
        Lecture CDA3103C_LAB = new Lecture("CDA 3103C", "Computer Logic & Org Lab", "", "BA1 122",
                16, 00, 16, 50, WEDNESDAY);
        Lecture COT3100C = new Lecture("COT 3100C", "Intro to Discrete", "", "CB1 121",
                14, 00, 15, 50, TUESDAY, THURSDAY);

        return Arrays.asList(CDA3103C, CDA3103C_LAB, COT3100C);
    }

}
