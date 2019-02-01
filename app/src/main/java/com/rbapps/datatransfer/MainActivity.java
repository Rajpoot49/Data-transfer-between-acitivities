package com.rbapps.datatransfer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button sign_in;
    EditText email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        sign_in = findViewById(R.id.login);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String validEmail= email.getText().toString();

                if (email.length() == 0 || password.length() == 0) {
                    if (email.length() != 0) {
                        password.setError("Error");
                    } else if (password.length() != 0) {
                        email.setError("Error");
                    } else {
                        email.setError("Error");
                        password.setError("Error");
                    }
                }

                else if(email.length()!=0 && password.length()!=0) {

                    if (!(isValid(validEmail))) {
                        Toast.makeText(getApplicationContext(), "Email is not valid", Toast.LENGTH_SHORT).show();
                    } else {
                        openSecondActivity();

                    }
                }
            }
        });

    }
    public static boolean isValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        if(!matcher.matches()){
            return false;
        }
        else {
            return matcher.matches();
        }
    }

    private void openSecondActivity() {

        String str = email.getText().toString();
        String str2 = password.getText().toString();

        Intent secondActivity = new Intent(this, Second_Activity.class);
        secondActivity.putExtra("Email", str);
        secondActivity.putExtra("Password", str2);
        startActivity(secondActivity);
    }
}
