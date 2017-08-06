package com.vegetarianbaconite.lazyknight;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.support.wearable.complications.ComplicationData;
import android.support.wearable.complications.ComplicationManager;
import android.support.wearable.complications.ComplicationProviderService;
import android.support.wearable.complications.ComplicationText;
import android.util.Log;

public class ScheduleComplicationService extends ComplicationProviderService {
    Schedule s;
    String LOG_KEY = "lazyknight-debug";

    /*
     * Julia is the coolest person on the planet. just wanted to let you know.
     */

    @Override
    public void onComplicationActivated(int complicationId, int type, ComplicationManager manager) {
        s = Schedule.getInstance();

        Log.d(LOG_KEY, "Complication Activated");
    }

    @Override
    public void onComplicationUpdate(int compID, int dataType, ComplicationManager complicationManager) {
        if (s == null) s = Schedule.getInstance();

        ComponentName thisProvider = new ComponentName(this, getClass());
        PendingIntent infoIntent = PendingIntent.getActivity(getApplicationContext(), 823,
                new Intent(getApplicationContext(), ClassInfoActivity.class), 0);

        ComplicationData data;
        Lecture current = s.getCurrentClass();
        Lecture next = s.getNextClass();
        Boolean classActive, watchingNext = false;

        classActive = current != null; //TODO: Broken
        if (next != null)
            watchingNext = next.getTimeTillStart(s.getDay(), s.now()) < 60; //TODO: Broken

        Log.d(LOG_KEY, "In class: " + classActive + "; Watching next: " + watchingNext);

        String title = classActive ? current.shortName : watchingNext ? next.shortName : "UCF";
        int progress = classActive ? current.getProgressInClass(s.getDay(), s.now()) :
                watchingNext ? next.getTimeTillStart(s.getDay(), s.now()) : 60;

        Log.d(LOG_KEY, "On Complication Update... Type: " + dataType);

        if (classActive || watchingNext)
            data = new ComplicationData.Builder(ComplicationData.TYPE_RANGED_VALUE)
                    .setValue(progress)
                    .setMinValue(0)
                    .setMaxValue(classActive ? current.getLength(s.getDay()) : 60)
                    .setShortTitle(ComplicationText.plainText(title))
                    .setTapAction(infoIntent)
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
