package com.example.akshayjk.attempt1.HFW_Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.akshayjk.attempt1.Base_Activities.SecondActivity;
import com.example.akshayjk.attempt1.Helper.FormSubmission;
import com.example.akshayjk.attempt1.Helper.ImageViewer;
import com.example.akshayjk.attempt1.Helper.LoginForm;
import com.example.akshayjk.attempt1.R;

/**
 * Created by AkshayJk on 30-Nov-17.
 */

public class GroupExercise extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(GroupExercise.this, HFW.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupexercise);
        TextView textView=findViewById(R.id.getv1);
        String htmlString="&#8226; Please arrive no later the FIVE minutes before the start of the class. If you do not your spot will be given away to walk-ins.<br/>&#8226; For safety, participants will not be admitted into class after the warm up has been completed. (To ensure a pleasant experience for all participants, once a yoga class has begun no one will be admitted) <br/>&#8226; Appropriate group exercise clothing and footwear is required.<br/>&#8226; No street shoes, boots, open toed shoes, black-soled or marking shoes are permitted.<br/>&#8226; No food or drinks are allowed, except water and sports drinks in a sealed bottle.<br/>&#8226; The stereo equipment is for group exercise classes only.<br/>&#8226; Use of Ipods/mp3 players, cell phones, and excessive talking are not permitted in any class.<br/>&#8226; Please do remove any equipment from the Group Exercise Studios.<br/> ";
        textView.setText(Html.fromHtml(htmlString));

        Button b1=findViewById(R.id.button_gefall);
        Button b2=findViewById(R.id.button_gefinals);
        Button b3=findViewById(R.id.button_gedesc);
        Button b4=findViewById(R.id.button_gereg);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GroupExercise.this,ImageViewer.class);
                intent.putExtra("code",1);
                intent.putExtra("file",1);
                startActivity(intent);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GroupExercise.this,ImageViewer.class);
                intent.putExtra("code",1);
                intent.putExtra("file",2);
                startActivity(intent);
                finish();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GroupExercise.this,ImageViewer.class);
                intent.putExtra("code",1);
                intent.putExtra("file",3);
                startActivity(intent);
                finish();

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GroupExercise.this, LoginForm.class);
                intent.putExtra("code",2);
                startActivity(intent);
            }
        });
    }
}
