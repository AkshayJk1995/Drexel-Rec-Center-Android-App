package com.example.akshayjk.attempt1.IntraSports_Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.akshayjk.attempt1.Helper.FormSubmission;
import com.example.akshayjk.attempt1.Helper.RegisterData;
import com.example.akshayjk.attempt1.R;
import com.example.akshayjk.attempt1.SQL.DatabaseHandler;

import java.util.List;

/**
 * Created by AkshayJk on 22-Nov-17.
 */

public class TestPrint extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bundle bundle=getIntent().getExtras();
        int code=bundle.getInt("code");
        Intent intent = new Intent(TestPrint.this, FormSubmission.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("code",code);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView textView = findViewById(R.id.tv1);
        DatabaseHandler db = new DatabaseHandler(TestPrint.this, null, null, 4);
        List<RegisterData> list = db.getAllRegister();
        String name=db.getTableContacts();
        String datab=db.getDatabaseName();
        textView.append(datab+" : "+name+"\n");
        if(list.isEmpty())
            textView.append("Empty Table");

        for (RegisterData registerData : list) {
            textView.append("\n"+registerData.getfirstName() + " " + registerData.getPassword() + " " + registerData.getdOB() + " " + registerData.getEmailId()+"\n");
        }

    }
}
