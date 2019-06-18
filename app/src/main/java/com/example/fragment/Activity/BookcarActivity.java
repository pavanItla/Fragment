package com.example.fragment.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.Model.CarBookingResponse;
import com.example.fragment.Model.DefaultResponse;
import com.example.fragment.R;
import com.example.fragment.SharedPreferences.UserSessionManager;
import com.example.fragment.api.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookcarActivity extends AppCompatActivity {

    String regexStr = "^[0-9]$";

    ImageView img,Car;
    TextView txthome,Bike,carget1;
    EditText name, mbl;
    Spinner sp1, sp2, sp3, sp4;
    Button btn;
    String emails;
    String Imgurl;

    String man1,man2,man3;
    UserSessionManager seesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookcar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        seesion=new UserSessionManager(this);
        HashMap<String,String> profile=seesion.getUserDetails();
        emails=profile.get("email");

        Intent intent=getIntent();
        man1=intent.getStringExtra("id");
        man3=intent.getStringExtra("text");
        man2=intent.getStringExtra("image");
        Bike=findViewById(R.id.carget);
        Car=findViewById(R.id.carimg);


        Bike.setText(man3);
        //Car.setImageResource();
        Picasso.get().load(man2).into(Car);



       // Toast.makeText(getApplicationContext(),""+man1+man3+man2,Toast.LENGTH_LONG).show();
        /*ACTION BAR*/
        /*this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action);
        img = (ImageView) findViewById(R.id.back);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookcarActivity.this, CarActivtiy.class);
                startActivity(intent);
            }
        });

        *//*ACTION to HOME*//*
        txthome = (TextView) findViewById(R.id.txthome);
        txthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });*/

        carget1=(TextView)findViewById(R.id.carget);
        name = (EditText) findViewById(R.id.name);
        mbl = (EditText) findViewById(R.id.mobile);
        sp1 = (Spinner) findViewById(R.id.spn1);
        sp2 = (Spinner) findViewById(R.id.spn2);
        sp3 = (Spinner) findViewById(R.id.spn3);
        sp4 = (Spinner) findViewById(R.id.spn4);
        btn = (Button) findViewById(R.id.cbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                carBooking();
            }
        });


        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.pickup, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.spinner_text_color);
        sp1.setAdapter(adapter);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ///
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ///
            }
        });

        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.dropoff, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.spinner_text_color);
        sp2.setAdapter(adapter1);

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ///
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ///
            }
        });

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.start, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.spinner_text_color);
        sp3.setAdapter(adapter2);

        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ///
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ///
            }
        });

        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.persons, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.spinner_text_color);
        sp4.setAdapter(adapter3);

        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void carBooking() {
        String MobilePattern = "[0-9]{10}";

        String carname = carget1.getText().toString().trim();
        String Name = name.getText().toString().trim();
        String number = mbl.getText().toString().trim();
        String pickup = sp1.getSelectedItem().toString().trim();
        String drop = sp2.getSelectedItem().toString().trim();
        String starttime = sp3.getSelectedItem().toString().trim();
        String noofpersons = sp4.getSelectedItem().toString().trim();
//        String email = sp4.getSelectedItem().toString().trim();

        if (Name.isEmpty()) {
            name.setError("Name required");
            name.requestFocus();
        }
        else if (number.isEmpty()) {
            mbl.setError("Number required");
            mbl.requestFocus();
        }
        else if(mbl.getText().toString().length()<10 || number.length()>13 || number.matches(MobilePattern)==false  ) {

            mbl.setError("enter a valid phone number");
        }else if (pickup.equalsIgnoreCase("Pick up point")||pickup.isEmpty()){

            Toast.makeText(BookcarActivity.this,"Please select Pickup point",Toast.LENGTH_LONG).show();

        }else if (drop.equalsIgnoreCase("Drop off point")||drop.isEmpty()){

            Toast.makeText(BookcarActivity.this,"Please select Drop point",Toast.LENGTH_LONG).show();
        }else if (starttime.equalsIgnoreCase("Start time")||starttime.isEmpty()){

            Toast.makeText(BookcarActivity.this,"Please select Start time",Toast.LENGTH_LONG).show();

        }else if (noofpersons.equalsIgnoreCase("Persons")||noofpersons.isEmpty()){

            Toast.makeText(BookcarActivity.this,"Select no. of persons",Toast.LENGTH_LONG).show();

        }



        else {

//            Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
            Call<CarBookingResponse> Call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .Carbooking1(carname,Name, number, pickup, drop, starttime, noofpersons,emails);

            Call.enqueue(new Callback<CarBookingResponse>() {
                @Override
                public void onResponse(Call<CarBookingResponse> call, Response<CarBookingResponse> response) {

                    CarBookingResponse defaultResponse = response.body();

                    if ((defaultResponse != null ? defaultResponse.getStatus() : 0) == 1) {
                        String im = defaultResponse.getMessage();
                        Toast.makeText(BookcarActivity.this, "" + im, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(BookcarActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else if ((defaultResponse != null ? defaultResponse.getStatus() : 0) == 0) {
                        String im = defaultResponse.getMessage();
                        Toast.makeText(BookcarActivity.this, "" + im, Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<CarBookingResponse> call, Throwable t) {
            Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
                }
            });


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
