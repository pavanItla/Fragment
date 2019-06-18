package com.example.fragment.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragment.R;

public class PaymentActivity extends AppCompatActivity {
TextView payment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);




        Intent intent =getIntent();
        String price = intent.getStringExtra("price");
        payment=findViewById(R.id.payment);
        payment.setText(price.toString());
    }
}
