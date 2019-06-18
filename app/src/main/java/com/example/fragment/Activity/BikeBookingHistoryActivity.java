package com.example.fragment.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fragment.Adapter.AdapterBikeBooking;
import com.example.fragment.Adapter.AdapterCarBooking;
import com.example.fragment.Model.BikeResponse;
import com.example.fragment.Model.CarResponse;
import com.example.fragment.R;
import com.example.fragment.SharedPreferences.UserSessionManager;
import com.example.fragment.api.RetrofitClient;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BikeBookingHistoryActivity extends AppCompatActivity {


    UserSessionManager session;
    String users;
    RecyclerView rc;
    AdapterBikeBooking adapterBikeBooking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_booking_history);


        rc=(RecyclerView)findViewById(R.id.recycle1);

        session=new UserSessionManager(this);

        HashMap<String, String> profile = session.getUserDetails();

        users=profile.get("email");

        booking();
    }

                     public void booking(){

                               Call<BikeResponse> Call= RetrofitClient.getInstance().getApi().bikeBooking(users);

                               Call.enqueue(new Callback<BikeResponse>() {
                               @Override
                               public void onResponse(retrofit2.Call<BikeResponse> call, Response<BikeResponse> response) {

                               BikeResponse bikeResponse = response.body();

                               if ((bikeResponse != null ? bikeResponse.getStatus() : 0) == 1) {
                               List<BikeResponse.DataBean> dataBeans = response.body() != null ? response.body().getData() : null;

                               RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                               rc.setLayoutManager(layoutManager);
                               rc.setItemAnimator(new DefaultItemAnimator());

                               AdapterBikeBooking adapterCarBooking = new AdapterBikeBooking(dataBeans, getApplicationContext());
                               rc.setAdapter(adapterCarBooking);


                }
            }

            @Override
            public void onFailure(retrofit2.Call<BikeResponse> call, Throwable t) {

            }
        });

        }
}
