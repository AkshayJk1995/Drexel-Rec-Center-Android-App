package com.example.akshayjk.attempt1.Helper;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akshayjk.attempt1.HFW_Activities.GroupExercise;
import com.example.akshayjk.attempt1.IntraSports_Activities.IntraSports;
import com.example.akshayjk.attempt1.IntraSports_Activities.TestPrint;
import com.example.akshayjk.attempt1.R;
import com.example.akshayjk.attempt1.SQL.DatabaseHandler;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;


/**
 * Created by AkshayJk on 21-Nov-17.
 */

public class FormSubmission extends AppCompatActivity {

    EditText first, last, email, dob, pass, confpass;
    Button signup, login;
    DatabaseHandler db;
    String valid_email;
    Spinner spStatus;
    Spinner spGrad;
    Spinner spGender;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent;
        Bundle bundle = getIntent().getExtras();
        final int code = bundle.getInt("code");
        intent = new Intent(FormSubmission.this, LoginForm.class);
        intent.putExtra("code", code);
        Log.w("login", String.valueOf(code));
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        String[] gradYears = {"None", "2018", "2019", "2020", "2021", "2022", "2023"};
        String[] statusStrings = {"Freshman", "Sophomore", "Junior", "Senior", "Grad", "Faculty/Staff", "Pre-Junior"};
        String[] genderTypes = {"Male", "Female"};

        Bundle bundle = getIntent().getExtras();
        final int code = bundle.getInt("code");
        login = findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextAct1 = new Intent(FormSubmission.this, LoginForm.class);
                nextAct1.putExtra("code", code);
                startActivity(nextAct1);
            }
        });
        email = (EditText) findViewById(R.id.editText3);

        email.addTextChangedListener(new TextWatcher() {

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

        ArrayAdapter<String> adapter1;
        ArrayAdapter<String> adapter2;
        ArrayAdapter<String> adapter3;

        spStatus = findViewById(R.id.spinnerstat);
        spGrad = findViewById(R.id.spinnergrad);
        spGender = findViewById(R.id.spinnergender);

        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, statusStrings);
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gradYears);
        adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genderTypes);

        spStatus.setAdapter(adapter1);
        spGrad.setAdapter(adapter2);
        spGender.setAdapter(adapter3);

        first = findViewById(R.id.editText1);
        last = findViewById(R.id.editText2);
        dob = findViewById(R.id.editText5);
        pass = findViewById(R.id.editText4);
        Button button = findViewById(R.id.button_test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.playtv);
                textView.setText(first.getText().toString());
                textView.append(last.getText().toString());
                textView.append(dob.getText().toString());
                textView.append(pass.getText().toString());
                textView.append(spGrad.getSelectedItem().toString());
                textView.append(spStatus.getSelectedItem().toString());
                textView.append(spGender.getSelectedItem().toString());
                Intent intent = new Intent(FormSubmission.this, TestPrint.class);
                startActivity(intent);
            }
        });

        signup = findViewById(R.id.button_reg);
        confpass = findViewById(R.id.editText6);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edfirst = first.getText().toString().trim();
                String edlast = last.getText().toString().trim();
                String eddob = dob.getText().toString().trim();
                String edpass = pass.getText().toString().trim();
                String edconfpass = confpass.getText().toString().trim();
                String edemail = email.getText().toString().trim();
                String edstatus = spStatus.getSelectedItem().toString().trim();
                String edgrad = spStatus.getSelectedItem().toString().trim();
                String edgender = spStatus.getSelectedItem().toString().trim();

                if (edpass.equals(edconfpass)) {
                    if (edemail.isEmpty() || edpass.isEmpty() || eddob.isEmpty() || edfirst.isEmpty() || edlast.isEmpty())
                        Toast.makeText(getApplicationContext(), "Fill all fields to sign up", Toast.LENGTH_LONG).show();
                    else {
                        try {
                            db = new DatabaseHandler(FormSubmission.this, null, null, 4);
                            if (db.checkAcc(edemail)) {
                                Toast.makeText(getApplicationContext(), "Account Already Exists, click Login to access account", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "New Account", Toast.LENGTH_LONG).show();
                                RegisterData reg = new RegisterData();

                                reg.setfirstName(edfirst);
                                reg.setlastName(edlast);
                                reg.setEmailId(edemail);
                                reg.setDoB(eddob);
                                reg.setPassword(edpass);
                                reg.set_Status(edstatus);
                                reg.setGrad(edgrad);
                                reg.setGender(edgender);
                                db.addregister(reg);
/*
                                PostHandler handler = new PostHandler(edfirst, edlast, edemail, edpass, edstatus, edgrad, eddob, edgender);
                                String result = null;
                                try {
                                    result = handler.execute(URL).get();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                } catch (ExecutionException e) {
                                    e.printStackTrace();
                                }
*/
                                Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                                Intent nextAct1 = new Intent(FormSubmission.this, LoginForm.class);
                                nextAct1.putExtra("code", 2);
                                startActivity(nextAct1);

                            }
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "SQLException Error", Toast.LENGTH_LONG).show();
                            e.printStackTrace();

                        }

                    }
                } else {

                    Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_LONG).show();
                    pass.setText("");
                    confpass.setText("");
                }
            }
        });
    }
/*
    public class PostHandler extends AsyncTask<String, Void, String> {
        OkHttpClient client = new OkHttpClient();
        String email, pass, first, last, status, grad, dob, gender;

        public PostHandler(String email, String password, String first, String last, String status, String grad, String dob, String gender) {
            this.email = email;
            this.pass = password;
            this.first = first;
            this.last = last;
            this.status = status;
            this.grad = grad;
            this.dob = dob;
            this.gender = gender;
        }

        @Override
        protected String doInBackground(String... params) {
            RequestBody formBody = new FormBody.Builder()
                    .add("first", first)
                    .add("last", last)
                    .add("email", email)
                    .add("pass", pass)
                    .add("status", status)
                    .add("grad", grad)
                    .add("dob", dob)
                    .add("gender", gender)
                    .build();

            Request request = new Request.Builder()
                    .url("https://www.imleagues.com/spa/account/registration?schoolId=abada3f10ecf44c6b8872432f538c2f9").post(formBody)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                if (!response.isSuccessful())
                    throw new IOException("Unexpected code " + response.toString());
                return response.body().string();
            } catch (Exception e) {
            }
            return null;
        }

        private String post(String url, String data) throws IOException {
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            RequestBody body = RequestBody.create(JSON, data);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        }
    }

*/
}