package com.example.MyExploration;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by Nathan on 2/15/14.
 */
public class MyActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    //public

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }



    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //Intent notifyIntent = new Intent(this, NotifyService.class);

        EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = Long.toString(calendar.getTimeInMillis() - System.currentTimeMillis());
        String message = editText.getText().toString();


        intent.putExtra(EXTRA_MESSAGE, message);
        //notifyIntent.putExtra("NOTIF",message);
        startActivity(intent);
        //startService(notifyIntent);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openSettings(){

        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);


    }
}