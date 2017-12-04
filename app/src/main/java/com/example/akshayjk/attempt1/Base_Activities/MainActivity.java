package com.example.akshayjk.attempt1.Base_Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.akshayjk.attempt1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nextAct=new Intent(MainActivity.this, SecondActivity.class);
                MainActivity.this.startActivity(nextAct);
                MainActivity.this.finish();
            }
        },3000);

    }
}
