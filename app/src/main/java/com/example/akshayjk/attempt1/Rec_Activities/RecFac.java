package com.example.akshayjk.attempt1.Rec_Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.akshayjk.attempt1.Base_Activities.SecondActivity;
import com.example.akshayjk.attempt1.R;

/**
 * Created by AkshayJk on 18-Nov-17.
 */

public class RecFac extends AppCompatActivity {

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent=new Intent(RecFac.this,SecondActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recfac1);

        Button button_rc=findViewById(R.id.button_rc);
        Button button_dac=findViewById(R.id.button_dac);
        Button button_bcaa=findViewById(R.id.button_bcaa);
        Button button_tc=findViewById(R.id.button_tc);
        Button button_kssc=findViewById(R.id.button_kssc);
        Button button_vac=findViewById(R.id.button_vac);

        button_rc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecFac.this,RecCenter.class);
                startActivity(intent);
                finish();
            }
        });

        button_dac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecFac.this, DaCenter.class);
                startActivity(intent);
                finish();
            }
        });

        button_bcaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecFac.this, BuckleyArmory.class);
                startActivity(intent);
                finish();
            }
        });
        button_tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecFac.this, TennisCourts.class);
                startActivity(intent);
                finish();
            }
        });
        button_kssc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecFac.this, SquashCenter.class);
                startActivity(intent);
                finish();
            }
        });
        button_vac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecFac.this, Vidas.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
