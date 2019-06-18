package com.example.fragment.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fragment.Adapter.AdapterCar;
import com.example.fragment.Model.CarImageResponse;
import com.example.fragment.R;
import com.example.fragment.api.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarActivtiy extends AppCompatActivity {

    ImageView img,txthome;
    RecyclerView rv;

    Button btn;
    AdapterCar adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_activtiy);

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

        rv=findViewById(R.id.car);
        btn=(Button)findViewById(R.id.bookcar);
        data();

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(CarActivtiy.this,BookcarActivity.class);
//                startActivity(intent);
//            }
//        });
    }


    public  void data(){

        Call<CarImageResponse> Call= RetrofitClient.getInstance().getApi().requestCar();

        Call.enqueue(new Callback<CarImageResponse>() {
            @Override
            public void onResponse(retrofit2.Call<CarImageResponse> call, Response<CarImageResponse> response) {
                CarImageResponse carImageResponse=response.body();

                if ((carImageResponse!=null? carImageResponse.getStatus():0)==1){

                    List<CarImageResponse.DataBean> dataBeans=response.body()!=null?response.body().getData():null;

//        adapter1=new CarAdapterActivity(models1,getApplicationContext());
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    rv.setLayoutManager(mLayoutManager);
                    rv.setItemAnimator(new DefaultItemAnimator());
                    adapter1=new AdapterCar(dataBeans,getApplicationContext());
                    rv.setAdapter(adapter1);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<CarImageResponse> call, Throwable t) {

            }
        });



    }

}

