package com.example.akshayjk.attempt1.IntraSports_Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akshayjk.attempt1.Base_Activities.SecondActivity;
import com.example.akshayjk.attempt1.Helper.FormSubmission;
import com.example.akshayjk.attempt1.Helper.LoginForm;
import com.example.akshayjk.attempt1.Helper.pdfread;
import com.example.akshayjk.attempt1.R;

/**
 * Created by AkshayJk on 21-Nov-17.
 */

public class IntraSports extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(IntraSports.this, SecondActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intrasports);

        Button button_signUp = (Button) findViewById(R.id.button_su);
        Button button_ls = (Button) findViewById(R.id.button_ls);
        TextView tv10 = (TextView) findViewById(R.id.rf_intro_tv10);
        tv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://drexel.edu/~/media/Files/recathletics/intramural/drexel-intramural-sports-signup.ashx?la=en"));
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Unable to start intent", Toast.LENGTH_LONG).show();
                }
            }
        });

        button_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextAct = new Intent(IntraSports.this, LoginForm.class);
                nextAct.putExtra("code",1);
                startActivity(nextAct);
                finish();

            }
        });

        button_ls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntraSports.this, pdfread.class);
                intent.putExtra("filename","leaguesports.pdf");
                intent.putExtra("code",2);
//                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivityForResult(intent,2);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


}
