package com.example.fragment.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragment.Adapter.AdapterBike;
import com.example.fragment.Model.BikeImageResponse;
import com.example.fragment.Model.ModelBike;
import com.example.fragment.R;
import com.example.fragment.api.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BikeActivity extends AppCompatActivity {
    ImageView img,txthome;

    RecyclerView rv;


    AdapterBike adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
      ImageView txthome=(ImageView)findViewById(R.id.acthome);
        txthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        /*img=(ImageView)findViewById(R.id.back);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                Intent intent=new Intent(getApplicationContext(),TravelActivity.class);
                startActivity(intent);
            }

        });
        *//*ACTION to HOME*//*
        txthome=(TextView)findViewById(R.id.txthome);
        txthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });*/

        rv=findViewById(R.id.bike);

        data();
    }

                         public  void data(){

                                     Call<BikeImageResponse> Call= RetrofitClient.getInstance().getApi().requestBike();
                                     Call.enqueue(new Callback<BikeImageResponse>() {
                                     @Override
                                     public void onResponse(retrofit2.Call<BikeImageResponse> call, Response<BikeImageResponse> response) {
                                     BikeImageResponse bikeImageResponse=response.body();

                                     if ((bikeImageResponse!=null? bikeImageResponse.getStatus():0)==1){

                                     List<BikeImageResponse.DataBean> dataBeans=response.body()!=null?response.body().getData():null;


                                     RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                                     rv.setLayoutManager(mLayoutManager);
                                     rv.setItemAnimator(new DefaultItemAnimator());
                                     adapter1=new AdapterBike(dataBeans,getApplicationContext());
                                     rv.setAdapter(adapter1);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<BikeImageResponse> call, Throwable t) {

            }
        });



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

