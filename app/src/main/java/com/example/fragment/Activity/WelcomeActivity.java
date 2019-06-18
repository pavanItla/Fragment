package com.example.fragment.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.fragment.R;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String number = intent.getStringExtra("number");


        Button btn=findViewById(R.id.et);
        Button btn1=findViewById(R.id.et1);
        Button btn2=findViewById(R.id.et2);


        btn.setText(name.toString());
        btn1.setText(email.toString());
        btn2.setText(number.toString());
    }
}
