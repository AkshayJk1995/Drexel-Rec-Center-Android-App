package com.example.akshayjk.attempt1.Alarm;


/**
 * Created by AkshayJk on 20-Nov-17.
 */

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.akshayjk.attempt1.R;
import com.example.akshayjk.attempt1.Rec_Activities.RecCenter;

import java.util.Calendar;

public class AlarmActivity extends Activity {

    private static final int JOB_ID=101;
    private TimePicker alarmTimePicker;
    private  TextView alarmList;
    private JobScheduler jobScheduler;
    private JobInfo jobInfo;
    private ComponentName componentName;


    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent=new Intent(AlarmActivity.this,RecCenter.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        alarmTimePicker = (TimePicker) findViewById(R.id.alarmTimePicker);
        ToggleButton alarmToggle = (ToggleButton) findViewById(R.id.alarmToggle);

    }

    public void onToggleClicked(View view) {
        alarmList=(TextView) findViewById(R.id.alarmList);
        Context context=getApplicationContext();
        if (((ToggleButton) view).isChecked()) {
            Log.d("MyActivity", "Alarm On");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
            calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());

            Calendar calendar1=Calendar.getInstance();
            componentName=new ComponentName(this, AlarmService.class);
            JobInfo.Builder builder=new JobInfo.Builder(JOB_ID,componentName);
            builder.setMinimumLatency(calendar.getTimeInMillis()-System.currentTimeMillis()-60000);
            builder.setPersisted(true);

            jobInfo=builder.build();
            jobScheduler=(JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
            jobScheduler.schedule(jobInfo);


        } else {
            jobScheduler.cancel(JOB_ID);
            Log.d("MyActivity", "Alarm Off");
        }
    }

}