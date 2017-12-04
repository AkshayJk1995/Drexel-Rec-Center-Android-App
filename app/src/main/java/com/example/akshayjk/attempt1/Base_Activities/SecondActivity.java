package com.example.akshayjk.attempt1.Base_Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.akshayjk.attempt1.HFW_Activities.HFW;
import com.example.akshayjk.attempt1.R;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);



        final Button button_rf=findViewById(R.id.button_rf);
        final Button button_is=findViewById(R.id.button_is);
        final Button button_cs=findViewById(R.id.button_cs);
        final Button button_hfw=findViewById(R.id.button_hfw);

        button_rf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextAct=new Intent(SecondActivity.this, com.example.akshayjk.attempt1.Rec_Activities.RecFac.class);
                SecondActivity.this.startActivity(nextAct);
                SecondActivity.this.finish();

            }
        });

        button_is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextAct=new Intent(SecondActivity.this, com.example.akshayjk.attempt1.IntraSports_Activities.IntraSports.class);
                SecondActivity.this.startActivity(nextAct);
                SecondActivity.this.finish();

            }
        });

        button_cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this, com.example.akshayjk.attempt1.ClubSports_Activities.ClubSports.class);
                startActivity(intent);
                finish();
            }
        });

        button_hfw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this, HFW.class);
                startActivity(intent);
                finish();
            }
        });
    }

}