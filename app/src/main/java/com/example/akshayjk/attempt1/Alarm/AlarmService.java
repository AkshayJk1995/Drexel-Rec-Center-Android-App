package com.example.akshayjk.attempt1.Alarm;

/**
 * Created by AkshayJk on 21-Nov-17.
 */
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.example.akshayjk.attempt1.R;

public class AlarmService extends JobService {
    private NotificationManager alarmNotificationManager;
    private AlarmScheduler alarmScheduler;

    @Override
    public boolean onStartJob(final JobParameters params) {
        alarmScheduler=new AlarmScheduler(){
            @Override
            protected void onPostExecute(String s) {
                alarmNotificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                Uri alarmSound= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
                NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(
                        getApplicationContext()).setContentTitle("Alarm").setSmallIcon(R.drawable.dragon1)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(s))
                        .setContentText(s)
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setVibrate(new long[]{1000,1000,1000,1000,1000})
                        .setLights(0xff00ff00, 300, 100)
                        .setSound(alarmSound);
                alarmNotificationManager.notify(1, alamNotificationBuilder.build());
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                jobFinished(params,false);
            }
        };
        alarmScheduler.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        alarmScheduler.cancel(false);
        return false;
    }
}
