package com.example.fragment.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fragment.Adapter.AdapterBedBooking;
import com.example.fragment.Adapter.AdapterBikeBooking;
import com.example.fragment.Model.BedResponse;
import com.example.fragment.Model.BikeResponse;
import com.example.fragment.R;
import com.example.fragment.SharedPreferences.UserSessionManager;
import com.example.fragment.api.RetrofitClient;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BedBookingHistoryActivity extends AppCompatActivity {


    UserSessionManager session;
    String users;
    RecyclerView rc;
    AdapterBedBooking adapterBedBooking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_booking_history);


        rc = (RecyclerView) findViewById(R.id.recycle2);

        session = new UserSessionManager(this);

        HashMap<String, String> profile = session.getUserDetails();

        users = profile.get("email");

        booking();
    }

             public void booking() {

                                  Call<BedResponse> Call = RetrofitClient.getInstance().getApi().bedBooking(users);

                                  Call.enqueue(new Callback<BedResponse>() {
                                  @Override
                                  public void onResponse(retrofit2.Call<BedResponse> call, Response<BedResponse> response) {

                                  BedResponse bedResponse = response.body();

                                  if ((bedResponse != null ? bedResponse.getStatus() : 0) == 1) {
                                  List<BedResponse.DataBean> dataBeans = response.body() != null ? response.body().getData() : null;

                                  RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                                  rc.setLayoutManager(layoutManager);
                                  rc.setItemAnimator(new DefaultItemAnimator());

                                  AdapterBedBooking adapterBedBooking = new AdapterBedBooking(dataBeans, getApplicationContext());
                                  rc.setAdapter(adapterBedBooking);


                }
            }

            @Override
            public void onFailure(retrofit2.Call<BedResponse> call, Throwable t) {

            }
        });
    }
}
