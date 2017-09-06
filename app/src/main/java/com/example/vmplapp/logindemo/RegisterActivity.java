package com.example.vmplapp.logindemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vmplapp on 28/8/17.
 */

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText fullname;
    EditText username;
    EditText email;
    EditText contact;
    EditText pwd;
    EditText confpwd;
    Spinner spinner;
    Button btnreg;

    String Fname,Uname,emailid,contno,pass,confpass;
    private static final String TAG = "RegisterActivity";
    private String usertype;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_reg);


        final DatabaseHandler db = new DatabaseHandler(this);

        fullname = (EditText) findViewById(R.id.fullname);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        contact = (EditText) findViewById(R.id.contact);
        pwd = (EditText) findViewById(R.id.pwd);
        confpwd = (EditText) findViewById(R.id.confpwd);
        spinner = (Spinner) findViewById(R.id.usertype);
        btnreg = (Button) findViewById(R.id.btnreg);


        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Student");
        categories.add("Teacher");
        categories.add("Department HOD");
        categories.add("College Admin");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fname = fullname.getText().toString();
                Uname = username.getText().toString();
                emailid = email.getText().toString();
                contno = contact.getText().toString();
                pass = pwd.getText().toString();
                confpass = confpwd.getText().toString();

                Log.w(TAG, "onClick: Variables are " + Fname + " " + Uname + " " + emailid + " " + contno + " " + pass + " " + confpass + " " + usertype);
                if (Fname.length() != 0 && Uname.length() != 0 && emailid.length() != 0 && contno.length() != 0 && pass.length() != 0 && confpass.length() != 0 && usertype.length() != 0) {
                    if (pass.equals(confpass)) {
                        Log.d("Insert: ", "Inserting ..");
                        //db.addUser(new MstUsers("" + Uname, "" + pass, "" + Fname, "" + contno, "" + emailid, "" + usertype, 0, 1));
                        db.addUser(new MstUsers(Uname, pass, Fname, contno, emailid, usertype, 0, 1));
                        finish();
                    } else
                        Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_LONG).show();

                }
                else
                    Toast.makeText(RegisterActivity.this, "Please fill All Fields", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
// On selecting a spinner item
        usertype = adapterView.getItemAtPosition(i).toString();

        // Showing selected spinner item
       // Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(RegisterActivity.this, "Please select UserType", Toast.LENGTH_LONG).show();

    }
}
