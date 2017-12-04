package com.example.akshayjk.attempt1.Alarm;

import android.os.AsyncTask;

/**
 * Created by AkshayJk on 28-Nov-17.
 */

public class AlarmScheduler extends AsyncTask<Void,Void,String> {
    @Override
    protected String doInBackground(Void... voids) {
        return "Time to hit the rec center!";
    }
}
