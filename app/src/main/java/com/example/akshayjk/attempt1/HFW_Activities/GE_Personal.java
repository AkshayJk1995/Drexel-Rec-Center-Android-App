package com.example.akshayjk.attempt1.HFW_Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.akshayjk.attempt1.Helper.GroupData;
import com.example.akshayjk.attempt1.R;
import com.example.akshayjk.attempt1.SQL.GEDatabaseHandler;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AkshayJk on 03-Dec-17.
 */

public class GE_Personal extends AppCompatActivity {

    public static GEDatabaseHandler gdb;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(GE_Personal.this, HFW.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gepersonal);
        Bundle bundle=getIntent().getExtras();
        String email=bundle.getString("email");
        gdb=new GEDatabaseHandler(this,"mydatabase.db",null,4);
        List<GroupData> groupData=new ArrayList<>();
        TextView textView=findViewById(R.id.personal_tv);

        groupData=gdb.getAllRegister();
        for(GroupData g:groupData){
            if(g.getEmailId().equals(email)){
                textView.append("\n\n"+g.getgroup()+"   "+g.getdOB()+"   "+g.gettiming());
            }
        }

    }
}
