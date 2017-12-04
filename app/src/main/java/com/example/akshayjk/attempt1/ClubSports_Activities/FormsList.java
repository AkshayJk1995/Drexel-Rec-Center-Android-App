package com.example.akshayjk.attempt1.ClubSports_Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akshayjk.attempt1.Base_Activities.SecondActivity;
import com.example.akshayjk.attempt1.Helper.pdfread;
import com.example.akshayjk.attempt1.R;

import org.w3c.dom.Text;

import java.io.File;

/**
 * Created by AkshayJk on 25-Nov-17.
 */

public class FormsList extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(FormsList.this,ClubSports.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formslist);
        final TextView textView=findViewById(R.id.form1);
        final TextView textView1=findViewById(R.id.form2);
        final TextView textView2=findViewById(R.id.form3);
        final TextView textView3=findViewById(R.id.form4);
        final TextView textView4=findViewById(R.id.form5);
        final TextView textView5=findViewById(R.id.form6);
        final TextView textView6=findViewById(R.id.form7);
        final TextView textView7=findViewById(R.id.form8);
        final TextView textView8=findViewById(R.id.form9);
        final TextView textView9=findViewById(R.id.form10);
        final TextView textView10=findViewById(R.id.form11);
        final TextView textView11=findViewById(R.id.form12);
        final TextView textView12=findViewById(R.id.form13);
        final TextView textView13=findViewById(R.id.form14);
        final TextView textView14=findViewById(R.id.form15);
        final TextView textView15=findViewById(R.id.form16);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","Club Sports Registration Instructions.pdf");
                //startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","Club Sports Physical.pdf");
//                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);

            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","drexel-club-sports-liability.pdf");
//                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","ClubSportsManual.pdf");
                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);
            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","K2Accident Incident Form.pdf");
//                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);
            }
        });

        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","UInjury Report.pdf");
//                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);
            }
        });

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","drexel-club-sports-travel-safety.pdf");
//                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);
            }
        });

        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","drexel-club-sports-game-report.pdf");
//                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);
            }
        });

        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","drexel-club-sports-visiting-teams.pdf");
//                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);
            }
        });

        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","drexel-club-sports-cash-deposit.pdf");
//                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);
            }
        });

        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","drexel-club-sports-W9.pdf");
//                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);
            }
        });

        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","Independent Contractor Determination.pdf");
//                startActivity(intent);
                intent.putExtra("code",4);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivityForResult(intent,4);
            }
        });

        textView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","drexel-club-sports-coach-info.pdf");
//                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);
            }
        });

        textView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","drexel-club-sports-coach-agreement.pdf");
//                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);
            }
        });

        textView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","drexel-club-sports-conduct-memo.pdf");
//                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);
            }
        });

        textView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormsList.this,pdfread.class);
                intent.putExtra("filename","Volunteer Unpaid Intern Description Form Questions.pdf");
//                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                intent.putExtra("code",4);
                startActivityForResult(intent,4);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}

