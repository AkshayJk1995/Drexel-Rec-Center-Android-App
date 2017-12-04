package com.example.akshayjk.attempt1.Rec_Activities;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.akshayjk.attempt1.Alarm.AlarmActivity;
import com.example.akshayjk.attempt1.Helper.pdfread;
import com.example.akshayjk.attempt1.R;

/**
 * Created by AkshayJk on 19-Nov-17.
 */

public class RecCenter extends AppCompatActivity {

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent=new Intent(RecCenter.this,RecFac.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reccenter);
        Button b1=findViewById(R.id.button_fachours);
        Button b2=findViewById(R.id.button_alarm1);
        Button b3=findViewById(R.id.button_recmap);
        final Context context=getApplicationContext();

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextAct=new Intent(RecCenter.this, com.example.akshayjk.attempt1.Alarm.AlarmActivity.class);
                startActivity(nextAct);
                finish();

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextAct=new Intent(RecCenter.this, pdfread.class);
                nextAct.putExtra("filename","fachours1.pdf");
                nextAct.putExtra("code",1);
                //startActivity(nextAct);
                nextAct.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivityForResult(nextAct,1);
                finish();
            }

            });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yourAddress="Drexel Recreation Center and Gym" ;
                String map = "http://maps.google.co.in/maps?q=" + yourAddress;
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(map));
                context.startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
