package com.example.akshayjk.attempt1.IntraSports_Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.akshayjk.attempt1.R;

/**
 * Created by AkshayJk on 22-Nov-17.
 */

public class PostSubmission extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(PostSubmission.this, IntraSports.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postsubmit);

        ImageButton imageButton=findViewById(R.id.logo);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.imleagues&hl=en"));
                try{
                    startActivity(intent);
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Unable to start intent",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
