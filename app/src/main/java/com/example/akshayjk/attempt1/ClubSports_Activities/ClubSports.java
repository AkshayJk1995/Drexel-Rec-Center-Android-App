package com.example.akshayjk.attempt1.ClubSports_Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.akshayjk.attempt1.Base_Activities.SecondActivity;
import com.example.akshayjk.attempt1.Helper.pdfread;
import com.example.akshayjk.attempt1.IntraSports_Activities.IntraSports;
import com.example.akshayjk.attempt1.R;

/**
 * Created by AkshayJk on 23-Nov-17.
 */

public class ClubSports extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ClubSports.this, SecondActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubsports);

        Button lcs = findViewById(R.id.button_lcs);
        Button forms = findViewById(R.id.button_forms);
        Button sch = findViewById(R.id.button_schedule);

        lcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClubSports.this, pdfread.class);
                intent.putExtra("filename", "club_sports.pdf");
                //startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",3);
                startActivityForResult(intent, 3);
                finish();
            }
        });

        forms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClubSports.this, FormsList.class);
                startActivity(intent);
                finish();
            }
        });

        sch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ClubSports.this, CS_Schedule.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}