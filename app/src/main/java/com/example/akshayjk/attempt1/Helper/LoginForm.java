package com.example.akshayjk.attempt1.Helper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akshayjk.attempt1.HFW_Activities.GE_Form;
import com.example.akshayjk.attempt1.HFW_Activities.GroupExercise;
import com.example.akshayjk.attempt1.IntraSports_Activities.IntraSports;
import com.example.akshayjk.attempt1.IntraSports_Activities.PostSubmission;
import com.example.akshayjk.attempt1.R;
import com.example.akshayjk.attempt1.Rec_Activities.RecFac;
import com.example.akshayjk.attempt1.SQL.DatabaseHandler;

import org.w3c.dom.Text;

import java.text.Normalizer;
import java.util.List;

/**
 * Created by AkshayJk on 22-Nov-17.
 */

public class LoginForm extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bundle bundle=getIntent().getExtras();
        int code=bundle.getInt("code");
        switch (code){
            case 1: Intent intent = new Intent(LoginForm.this, IntraSports.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    Log.w("login", String.valueOf(code));
                    startActivity(intent);
                    finish();
                    break;
            case 2: Intent intent1 = new Intent(LoginForm.this, GroupExercise.class);
                    Log.w("login", String.valueOf(code));
                    intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent1);
                    finish();
                    break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginform);

        final EditText pass=findViewById(R.id.loginpass);
        final DatabaseHandler db=new DatabaseHandler(this,"mydatabase.db", null,4);
        final EditText email = findViewById(R.id.loginmail);

        Bundle bundle=getIntent().getExtras();
        final int code=bundle.getInt("code");
        email.addTextChangedListener(new TextWatcher() {
        String valid_email;

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

                // TODO Auto-generated method stub
                Is_Valid_Email(email); // pass your EditText Obj here.
            }

            public void Is_Valid_Email(EditText edt) {
                if (edt.getText().toString() == null) {
                    edt.setError("Invalid Email Address");
                    valid_email = null;
                } else if (isEmailValid(edt.getText().toString()) == false) {
                    edt.setError("Invalid Email Address");
                    valid_email = null;
                } else {
                    valid_email = edt.getText().toString();
                }
            }

            boolean isEmailValid(String email) {
                if (email.contains("@drexel.edu") || email.contains("@drexelmed,edu") || email.contains("@coe.drexel.edu") || email.contains("@acnatscl.org"))
                    return true;
                else
                    return false;
            }


        });

        Button button=findViewById(R.id.button_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edemail=email.getText().toString().trim();
                String edpass=pass.getText().toString().trim();
                Intent intent;
                if(db.logon(edemail,edpass)){
                    switch (code){
                        case 1: intent=new Intent(LoginForm.this,PostSubmission.class);
                                startActivity(intent);
                                finish();
                                break;
                        case 2: intent=new Intent(LoginForm.this, GE_Form.class);
                                intent.putExtra("email",edemail);
                                startActivity(intent);
                                finish();
                                break;
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong Username/Password", Toast.LENGTH_LONG).show();
                    email.setText("");
                    pass.setText("");
                 /*   List<RegisterData> list = db.getAllRegister();
                    String name=db.getTableContacts();
                    String datab=db.getDatabaseName();
                    TextView textView=findViewById(R.id.finaltext);
                    textView.append(datab+" : "+name+"\n");
                    if(list.isEmpty())
                        textView.append("Empty Table");

                    for (RegisterData registerData : list) {
                        textView.append("\n"+registerData.getfirstName()  + registerData.getPassword() + registerData.getdOB()  + registerData.getEmailId()+"\n");
                        textView.append(("You entered"+edemail+edpass));
                    }*/

                }
            }
        });

        TextView textView=findViewById(R.id.finaltext);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginForm.this, FormSubmission.class);
                intent.putExtra("code",code);
                Log.w("login_to_Form", String.valueOf(code));
                startActivity(intent);
                finish();
            }
        });

    }


}
