package com.example.fragment.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fragment.Adapter.AdapterBed;
import com.example.fragment.Adapter.AdapterCar;
import com.example.fragment.Model.BedImageResponse;
import com.example.fragment.Model.CarImageResponse;
import com.example.fragment.R;
import com.example.fragment.api.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookActivity extends AppCompatActivity {
    ImageView img,txthome;
//    TextView txthome;
    RecyclerView rv;

    Button btn;
    AdapterBed adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book2);
        /*ACTION BAR*/
        //this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setCustomView(R.layout.custom_action);

        /*img = (ImageView) findViewById(R.id.back);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        *//*ACTION to HOME*//*
        txthome = (ImageView) findViewById(R.id.acthome);
        txthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
*/
        rv=findViewById(R.id.bed);
        data();

    }




               public  void data(){

                               Call<BedImageResponse> Call= RetrofitClient.getInstance().getApi().requestBed();

                               Call.enqueue(new Callback<BedImageResponse>() {
                               @Override
                               public void onResponse(retrofit2.Call<BedImageResponse> call, Response<BedImageResponse> response) {
                               BedImageResponse carImageResponse=response.body();

                               if ((carImageResponse!=null? carImageResponse.getStatus():0)==1){

                               List<BedImageResponse.DataBean> dataBeans=response.body()!=null?response.body().getData():null;
                               RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                               rv.setLayoutManager(mLayoutManager);
                               rv.setItemAnimator(new DefaultItemAnimator());
                               adapter1=new AdapterBed(dataBeans,getApplicationContext());
                               rv.setAdapter(adapter1);
                    }
                }

                @Override
                public void onFailure(retrofit2.Call<BedImageResponse> call, Throwable t) {

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

