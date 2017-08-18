package com.vegetarianbaconite.lazyknight;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ClassInfoActivity extends Activity {

    private TextView classCode, name, prof, room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_info);

        classCode = (TextView) findViewById(R.id.ciClass);
        name = (TextView) findViewById(R.id.ciName);
        prof = (TextView) findViewById(R.id.ciProfessor);
        room = (TextView) findViewById(R.id.ciRoom);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Schedule s = Schedule.getInstance();
        Lecture l = s.getCurrentClass() != null ? s.getCurrentClass() : s.getNextClass();

        if (l == null) {
            classCode.setText("NONE");
            name.setText("No Class");
        } else {
            classCode.setText(l.getShortName());
            name.setText(l.getClassName());
            prof.setText(l.getProfessor());
            room.setText(l.getRoom());
        }
    }
}
