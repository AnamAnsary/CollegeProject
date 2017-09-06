package com.example.vmplapp.logindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by vmplapp on 5/9/17.
 */

public class ClgAdminActivity extends AppCompatActivity {

    Button cr;
    Button ap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clgadmin);

        cr = (Button) findViewById(R.id.btncreate);
        ap = (Button) findViewById(R.id.btnapprove);

        cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClgAdminActivity.this, CreateDeptActivity.class);
                startActivity(intent);
            }
        });

        ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(ClgAdminActivity.this, ApproveHodActivity.class);
                startActivity(intent);*/
            }
        });
    }
}