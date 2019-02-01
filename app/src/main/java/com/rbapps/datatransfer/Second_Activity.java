package com.rbapps.datatransfer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Second_Activity extends AppCompatActivity {

    String data;
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);

        tv1= findViewById(R.id.email);
        tv2= findViewById(R.id.password);

        Intent getData = getIntent();

        if(getData !=null){
            if(getData.hasExtra("Email")){
                data = getData.getStringExtra("Email");
                tv1.setText(data);
                Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
            }
            if(getData.hasExtra("Password")){
                data = getData.getStringExtra("Password");
                tv2.setText(data);
            }
        }
        else {
            tv1.setText("Data Not Found");
            tv2.setText("Data Not Found");
        }

    }
}
