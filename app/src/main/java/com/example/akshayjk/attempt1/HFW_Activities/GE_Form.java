package com.example.akshayjk.attempt1.HFW_Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akshayjk.attempt1.Helper.GroupData;
import com.example.akshayjk.attempt1.R;
import com.example.akshayjk.attempt1.SQL.GEDatabaseHandler;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by AkshayJk on 01-Dec-17.
 */

public class GE_Form extends AppCompatActivity{

    public static GEDatabaseHandler gdb;
    public List<GroupData> groupData=new ArrayList<GroupData>();
    public Spinner spTypes,spDays,spTimings;
    public Button button;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(GE_Form.this, HFW.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geform);
        Bundle bundle = getIntent().getExtras();
        final String email = bundle.getString("email");
        button = findViewById(R.id.button_registerge);

        gdb = new GEDatabaseHandler(GE_Form.this, "mydatabase.db", null, 4);
        String[] types = {"Bodypump", "Barre", "Cycle 45"};
        String[] days;
        String[] timings;
        ArrayAdapter<String> adapter1;
        final ArrayList<String> s1 = new ArrayList<>();
        final ArrayList<String> s2 = new ArrayList<String>();
        final String[] s3;
        final String[] s4;
        spTypes = findViewById(R.id.ge_sp1);
        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
        spTypes.setAdapter(adapter1);
        spDays = findViewById(R.id.ge_sp2);
        spTimings = findViewById(R.id.ge_sp3);
        final TextView textView = findViewById(R.id.test2);
        spTypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String group = spTypes.getSelectedItem().toString().trim();
                groupData = gdb.retTypes(group);
                s1.clear();
                for (GroupData g : groupData) {
                    s1.add(g.getdOB());
                    textView.append(g.getdOB() + " " + g.getgroup() + " " + g.gettiming() + "\n");

                }
                Set<String> hs = new HashSet<>();
                hs.addAll(s1);
                s1.clear();
                s1.addAll(hs);
                ArrayAdapter<String> adapter2;
                adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, s1);
                adapter2.notifyDataSetChanged();
                spDays.setAdapter(adapter2);
                spDays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String days = spDays.getSelectedItem().toString().trim();
                        s2.clear();
                        groupData = gdb.retTypes(group, days);
                        for (GroupData g : groupData) {
                            s2.add(String.valueOf(g.gettiming()));
                        }
                        Set<String> hs = new HashSet<>();
                        hs.addAll(s2);
                        s2.clear();
                        s2.addAll(hs);
                        ArrayAdapter<String> adapter3;
                        adapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, s2);
                        adapter3.notifyDataSetChanged();
                        spTimings.setAdapter(adapter3);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


                if (groupData.isEmpty()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                    Calendar calendar = Calendar.getInstance();
                    String time = simpleDateFormat.format(calendar.getTime());
                    String nowtime = time.replace(":", "");
                    int timeNow = Integer.parseInt(nowtime);
                    nowtime = "0" + new Integer(timeNow).toString();

                    Toast.makeText(getApplicationContext(), nowtime, Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edex = spTypes.getSelectedItem().toString().trim();
                String eddoe = spDays.getSelectedItem().toString().trim();
                int edtime = Integer.parseInt(spTimings.getSelectedItem().toString().trim());
                GroupData gd = new GroupData();
                if (gdb.checkexists(email, edex, eddoe, edtime) != 0) {
                    Toast.makeText(getApplicationContext(), "Already Registered", Toast.LENGTH_LONG).show();
                } else {
                    if (gdb.checkcount(edex, eddoe, edtime) < 5) {
                        gd.setEmailId(email);
                        gd.setDoB(eddoe);
                        gd.setgroup(edex);
                        gd.settiming(edtime);
                        gdb.addRegister(gd);
                        textView.setText("");

                        Intent intent=new Intent(GE_Form.this,GE_Personal.class);
                        intent.putExtra("email",email);
                        startActivity(intent);
                        finish();
                    }

                    else{
                        Toast.makeText(getApplicationContext(),"Group Exercise Full!",Toast.LENGTH_LONG).show();
                    }
//                        Intent intent=new Intent(GE_Form.this, PostRegistration.class);
//                        startActivity(intent);
//                        finish();
                }
            }
        });

    }

}

