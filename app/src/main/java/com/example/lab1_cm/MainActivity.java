package com.example.lab1_cm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText email;

    TextView fName;
    TextView lName;
    TextView e_mail;

     String StringFirstName;
     String StringLastName;
     String StringEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);

        fName = findViewById(R.id.FName);
        lName = findViewById(R.id.LName);
        e_mail = findViewById(R.id.TVEmail);



    }

    public void onClick(View view){

        StringFirstName = firstName.getText().toString();
        fName.setText("First Name: "+StringFirstName);

        StringLastName = lastName.getText().toString();
        lName.setText("Last Name: " + StringLastName);

        StringEmail = email.getText().toString();
        e_mail.setText("E-mail: " + StringEmail);


    }
}