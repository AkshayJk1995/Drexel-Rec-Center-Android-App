package com.example.akshayjk.attempt1.HFW_Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.akshayjk.attempt1.Helper.GroupData;
import com.example.akshayjk.attempt1.R;
import com.example.akshayjk.attempt1.SQL.GEDatabaseHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AkshayJk on 02-Dec-17.
 */

public class PostRegistration extends AppCompatActivity {

    public static GEDatabaseHandler gdb;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(PostRegistration.this, GE_Form.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postreg);
        TextView textView=findViewById(R.id.postreg_tv);

        List<GroupData> groupDataList=new ArrayList<>();
        gdb=new GEDatabaseHandler(this,null,null,4);
        groupDataList=gdb.getAllRegister();
        if(groupDataList.isEmpty())
            textView.append("Empty table again!");
        for(GroupData g:groupDataList){
            textView.append("\n"+g.getEmailId()+" "+g.getgroup()+" "+g.getdOB()+" "+g.gettiming());
        }
    }
}
