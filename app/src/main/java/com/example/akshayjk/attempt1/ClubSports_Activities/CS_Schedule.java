package com.example.akshayjk.attempt1.ClubSports_Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.akshayjk.attempt1.Base_Activities.SecondActivity;
import com.example.akshayjk.attempt1.Helper.pdfread;
import com.example.akshayjk.attempt1.R;

/**
 * Created by AkshayJk on 29-Nov-17.
 */

public class CS_Schedule extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(CS_Schedule.this, ClubSports.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csschedule);

        Button b1=findViewById(R.id.button_admin);
        Button b2=findViewById(R.id.button_hschedule);
        Button b3=findViewById(R.id.button_fallschedule);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CS_Schedule.this,pdfread.class);
                intent.putExtra("filename","admin_schedule_cs.pdf");
                intent.putExtra("code", 5);
                startActivity(intent);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CS_Schedule.this,pdfread.class);
                intent.putExtra("filename","home_schedule_cs.pdf");
                intent.putExtra("code", 5);
                startActivity(intent);
                finish();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CS_Schedule.this,pdfread.class);
                intent.putExtra("filename","2016 Fall Competition Schedule.pdf");
                intent.putExtra("code", 5);
                startActivity(intent);
                finish();
            }
        });

    }
}
