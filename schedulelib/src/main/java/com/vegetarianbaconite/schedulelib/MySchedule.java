package com.vegetarianbaconite.schedulelib;

import java.util.Arrays;
import java.util.List;

import static com.vegetarianbaconite.schedulelib.Schedule.ClassDay.FRIDAY;
import static com.vegetarianbaconite.schedulelib.Schedule.ClassDay.MONDAY;
import static com.vegetarianbaconite.schedulelib.Schedule.ClassDay.THURSDAY;
import static com.vegetarianbaconite.schedulelib.Schedule.ClassDay.TUESDAY;
import static com.vegetarianbaconite.schedulelib.Schedule.ClassDay.WEDNESDAY;

public class MySchedule {
    static List<Lecture> freshmanFall() {
        Lecture COP3223H = new Lecture("COP 3223H", "H Intro to Prog w/ C", "Staff", "ENG1 227",
                9, 30, 10, 20, MONDAY, WEDNESDAY, FRIDAY);
        Lecture EDF2005 = new Lecture("EDF 2005", "Intro to Teaching Prof", "Philip Koger", "CB1 309",
                10, 30, 13, 20, WEDNESDAY);
        Lecture IDH1920H = new Lecture("IDH 1920H", "Honors Symposium", "Martin Dupuis", "CB1 121\nNSC 209",
                16, 30, 18, 50, MONDAY);
        Lecture MAC2313H = new Lecture("MAC 2313H", "H Calculus 3", "Zhisheng Shuai", "MSB 109",
                9, 0, 10, 50, TUESDAY, THURSDAY);
        Lecture SPC1603H = new Lecture("SPC 1603H", "H Fund Tech Pres", "George Musambira", "NSC 147",
                12, 0, 13, 15, TUESDAY, THURSDAY);

        return Arrays.asList(COP3223H, EDF2005, IDH1920H, MAC2313H, SPC1603H);
    }

    static List<Lecture> freshmanSpring() {
        Lecture COP3502H = new Lecture("COP 3502H", "H Computer Science 1", "Staff", "ENG1 286",
                9, 00, 10, 15, TUESDAY, THURSDAY);
        Lecture COT3100H = new Lecture("COP 3100H", "H Intro to Discrete", "Staff", "ENG1 383",
                9, 00, 10, 15, MONDAY, WEDNESDAY);
        Lecture EME2040 = new Lecture("EME 2040", "Intro to Tech for Ed", "Richard Thripp", "TA 303",
                10, 30, 13, 20, MONDAY);
        Lecture ENC1102H = new Lecture("ENC 1002H", "H Composition 2", "Marcy Galbreath", "BHC 128",
                12, 00, 13, 15, TUESDAY, THURSDAY);

        return Arrays.asList(COP3502H, COT3100H, EME2040, ENC1102H);
    }
}
