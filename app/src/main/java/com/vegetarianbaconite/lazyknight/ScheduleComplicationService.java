package com.vegetarianbaconite.lazyknight;

import android.support.wearable.complications.ComplicationData;
import android.support.wearable.complications.ComplicationManager;
import android.support.wearable.complications.ComplicationProviderService;
import android.support.wearable.complications.ComplicationText;

public class ScheduleComplicationService extends ComplicationProviderService {
    Schedule s;

    public ScheduleComplicationService() {
    }

    @Override
    public void onComplicationActivated(int complicationId, int type, ComplicationManager manager) {
        super.onComplicationActivated(complicationId, type, manager);

        s = new Schedule();
    }

    @Override
    public void onComplicationUpdate(int compID, int dataType, ComplicationManager complicationManager) {
        ComplicationData data;
        Lecture current = s.getCurrentClass();
        Lecture next = s.getNextClass();
        Lecture displayed = current != null ? current : next; //TODO: Check this

        switch (dataType) {
            case ComplicationData.TYPE_RANGED_VALUE:
                data = new ComplicationData.Builder(ComplicationData.TYPE_RANGED_VALUE)
                        .setValue(0) //TODO: This
                        .setMinValue(0)
                        .setMaxValue(30) //TODO: Make this responsive to class length
                        .setShortTitle(ComplicationText.plainText(displayed.className))
                        .build();
        }
    }
}
