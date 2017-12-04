package com.example.akshayjk.attempt1.HFW_Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.akshayjk.attempt1.Base_Activities.SecondActivity;
import com.example.akshayjk.attempt1.R;
import com.example.akshayjk.attempt1.Rec_Activities.RecCenter;
import com.example.akshayjk.attempt1.Rec_Activities.RecFac;

/**
 * Created by AkshayJk on 29-Nov-17.
 */

public class HFW extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(HFW.this, SecondActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hfw);
        TextView textView=findViewById(R.id.hfwtv1);
        String htmlString="&#8226; 50+ group exercise classes offered each week<br/>&#8226; Complimentary basic fitness assessments<br/>&#8226; Complimentary wellness consultations<br/>&#8226; Customized programming delivered to your door<br/>&#8226; Events and competitions";
        textView.append(Html.fromHtml(htmlString));
        Button b1=findViewById(R.id.button_ge);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HFW.this,GroupExercise.class);
                startActivity(intent);
                finish();
            }
        });

    }
}