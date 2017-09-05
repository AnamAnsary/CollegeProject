package com.example.vmplapp.logindemo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText password;
    EditText email;
    Button login;
    TextView register;

    String Lemail;
    String Lpass;
    String usertypeSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseHandler db = new DatabaseHandler(this);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.signin);
        register = (TextView) findViewById(R.id.reg);
        register.setClickable(true);

        login.setOnClickListener(new View.OnClickListener() {
        /*    email = getString
            password = (EditText) findViewById(R.id.password);*/

            @Override
            public void onClick(View view) {
               /* if(email.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                {
                Toast.makeText(MainActivity.this,"Successful Login",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(MainActivity.this,"Unsuccess",Toast.LENGTH_LONG).show();*/
                Lemail = email.getText().toString();
                Lpass = password.getText().toString();
                if (Lemail.length() != 0 && Lpass.length() != 0)
                {
                    MstUsers user = db.checkUser(Lemail,Lpass);
                    Toast.makeText(MainActivity.this, "FullName, contact no and usertype is "+ user.getFullname()+ " "+user.getContactno()+" "+user.getUsertype(), Toast.LENGTH_LONG).show();
                    usertypeSelected = user.getUsertype();



                }
                else
                    Toast.makeText(MainActivity.this, "Please fill All Fields", Toast.LENGTH_LONG).show();

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });
    }
}
