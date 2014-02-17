package com.example.MyExploration;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Nathan on 2/15/14.
 * Code was originally written by iturki on StackOverflow. http://stackoverflow.com/questions/12208008/how-to-create-a-reminder-notification
 */
public class NotifyService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand (Intent myIntent, int flags, int startId) {

        // Get the message from the intent
        String message = (String)myIntent.getExtras().get("NotificationText");


        NotificationManager mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification(R.drawable.icon, message, System.currentTimeMillis());
        Intent intent = new Intent(this , MyActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);
        notification.setLatestEventInfo(this, "Exploration", message, contentIntent);
        mNM.notify(1, notification);

        return 0;
    }
}
