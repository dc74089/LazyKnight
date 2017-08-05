package com.vegetarianbaconite.lazyknight;

import android.support.wearable.complications.ComplicationData;
import android.support.wearable.complications.ComplicationManager;
import android.support.wearable.complications.ComplicationProviderService;
import android.support.wearable.complications.ComplicationText;
import android.util.Log;

public class ScheduleComplicationService extends ComplicationProviderService {
    Schedule s;
    String LOG_KEY = "lazyknight-debug";

    @Override
    public void onComplicationActivated(int complicationId, int type, ComplicationManager manager) {
        s = Schedule.getInstance();

        Log.d(LOG_KEY, "Complication Activated");
    }

    @Override
    public void onComplicationUpdate(int compID, int dataType, ComplicationManager complicationManager) {
        if (s == null) s = Schedule.getInstance();

        ComplicationData data = null;
        Lecture current = s.getCurrentClass();
        Lecture next = s.getNextClass();
        Boolean classActive, watchingNext = false;

        classActive = current != null;
        if (next != null) watchingNext = next.getTimeTillStart(s.getDay(), s.now()) < 60;

        String title = classActive ? current.className : watchingNext ? next.className : "UCF";
        int progress = classActive ? current.getProgressInClass(s.getDay(), s.now()) :
                watchingNext ? next.getTimeTillStart(s.getDay(), s.now()) : 60;

        Log.d(LOG_KEY, "On Complication Update... Type: " + dataType);

        if (classActive || watchingNext)
            data = new ComplicationData.Builder(ComplicationData.TYPE_RANGED_VALUE)
                    .setValue(progress)
                    .setMinValue(0)
                    .setMaxValue(classActive ? current.getLength(s.getDay()) : 60)
                    .setShortTitle(ComplicationText.plainText(title))
                    .build();
        else
            data = new ComplicationData.Builder(ComplicationData.TYPE_NO_DATA).build();

        complicationManager.updateComplicationData(compID, data);
    }

    @Override
    public void onComplicationDeactivated(int complicationId) {
        Log.d(LOG_KEY, "Complication Deactivated");
    }
}
