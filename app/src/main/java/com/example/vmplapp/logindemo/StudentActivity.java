package com.example.vmplapp.logindemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by vmplapp on 5/9/17.
 */

public class StudentActivity extends AppCompatActivity {

    Button lect;
    Button issue;
    Button viewIssued;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        lect = (Button) findViewById(R.id.viewlect);
        issue = (Button) findViewById(R.id.issuebuk);
        viewIssued = (Button) findViewById(R.id.issuebuk);

    }
}