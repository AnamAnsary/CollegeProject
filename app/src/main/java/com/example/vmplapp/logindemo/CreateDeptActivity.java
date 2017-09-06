package com.example.vmplapp.logindemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vmplapp on 6/9/17.
 */


public class CreateDeptActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button sub;
    EditText deptname;
    Spinner hodspin;

    private static final String TAG = "CreateDeptActivity";
    private String HodSelected;
    private String dNameEntered;
    List<Integer> HodIdlist;
    List<String> Hodnamelist;
    private Integer IdOfHod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createdept);

        final DatabaseHandler db = new DatabaseHandler(this);

        sub = (Button) findViewById(R.id.btnsub);
        deptname = (EditText) findViewById(R.id.deptname);
        hodspin = (Spinner) findViewById(R.id.spinnerHods);

        /* spinner.setOnItemSelectedListener(this);

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
        spinner.setAdapter(dataAdapter);*/

        hodspin.setOnItemSelectedListener(this);
        Hodnamelist = new ArrayList<String>();
        HodIdlist = new ArrayList<Integer>();
        List<MstUsers> userHods = db.getAllHodUsers();
        for (MstUsers hodU : userHods){
            String log = "Id : " + hodU.getId() +" , Name : " + hodU.getFullname();
            Log.w(TAG, "Name : " + log );
            Hodnamelist.add(hodU.getFullname());
            HodIdlist.add(hodU.getId());

        }

        // Creating adapter for spinner
        ArrayAdapter<String> HodAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Hodnamelist);

        // Drop down layout style - list view with radio button
        HodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        hodspin.setAdapter(HodAdapter);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dNameEntered = deptname.getText().toString();
                if(dNameEntered.length() != 0)
                db.addDept(new MstDept(dNameEntered, IdOfHod, 1));
                else
                    Toast.makeText(CreateDeptActivity.this, "Please Enter Department Name.", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        HodSelected = adapterView.getItemAtPosition(i).toString();
        IdOfHod = HodIdlist.get(i);
        Log.w(TAG, "onItemSelected: Hod name "+HodSelected+" hodID " +IdOfHod);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(CreateDeptActivity.this, "Please select Department HOD.", Toast.LENGTH_LONG).show();
    }
}