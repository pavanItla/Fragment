package com.example.fragment.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.R;

public class TravelActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img,txthome;
//    TextView txthome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        /*ACTION BAR*/
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action);
        img=(ImageView)findViewById(R.id.back);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // finish();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        /*ACTION to HOME*/
        txthome=(ImageView)findViewById(R.id.acthome);
        txthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


        Button button=(Button)findViewById(R.id.btn);
        Button button1=(Button)findViewById(R.id.btn1);

        button.setOnClickListener(this);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn:

                Intent intent=new Intent(TravelActivity.this,CarActivtiy.class);
                startActivity(intent);
               break;

            case R.id.btn1:

                Intent intent1=new Intent(TravelActivity.this,BikeActivity.class);
                startActivity(intent1);

                break;

        }
    }
}
