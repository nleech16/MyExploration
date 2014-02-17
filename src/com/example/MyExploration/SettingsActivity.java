package com.example.MyExploration;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by Nathan on 2/15/14.
 */
public class SettingsActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setNotification(View view){

        EditText editText = (EditText) findViewById(R.id.notifText);
        TimePicker timePicker = (TimePicker) findViewById(R.id.notifTime);
        EditText editText2 = (EditText) findViewById(R.id.edit_message);

        String notificationText = editText.getText().toString();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, timePicker.getCurrentHour());
        calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
        calendar.set(Calendar.AM_PM, Calendar.AM);


        //editText.setText(Integer.toString(calendar.get(Calendar.AM_PM)));

        Intent intent = new Intent(this, NotifyService.class);
        intent.putExtra("NotificationText",notificationText);


        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent);



        Intent intent2 = new Intent(this, MyActivity.class);
        startActivity(intent2);




    }
}