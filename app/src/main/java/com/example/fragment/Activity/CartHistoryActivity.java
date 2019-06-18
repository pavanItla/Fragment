package com.example.fragment.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fragment.Adapter.AdapterCarBooking;
import com.example.fragment.Adapter.AdapterCartHistory;
import com.example.fragment.Model.CarResponse;
import com.example.fragment.Model.FoodCartFinalResponse;
import com.example.fragment.R;
import com.example.fragment.SharedPreferences.UserSessionManager;
import com.example.fragment.api.RetrofitClient;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartHistoryActivity extends AppCompatActivity {

    UserSessionManager session;
    String users;
    RecyclerView rc;
    AdapterCarBooking adapterCarBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_history);


        rc=(RecyclerView)findViewById(R.id.recycle3);

        session=new UserSessionManager(this);

        HashMap<String, String> profile = session.getUserDetails();

        users=profile.get("UserId");

        carthistory();
    }
    public void carthistory(){

        Call<FoodCartFinalResponse> Call= RetrofitClient.getInstance().getApi().requestCartBooking(users);

        Call.enqueue(new Callback<FoodCartFinalResponse>() {
            @Override
            public void onResponse(retrofit2.Call<FoodCartFinalResponse> call, Response<FoodCartFinalResponse> response) {

                FoodCartFinalResponse carResponse=response.body();

                if ((carResponse!=null? carResponse.getStatus():0)==1){
                    List<FoodCartFinalResponse.DataBean> dataBeans=response.body()!=null ? response.body().getData():null;

                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
                    rc.setLayoutManager(layoutManager);
                    rc.setItemAnimator(new DefaultItemAnimator());

                    AdapterCartHistory adapterCartHistory= new AdapterCartHistory(dataBeans,getApplicationContext());
                    rc.setAdapter(adapterCartHistory);

                }


            }

            @Override
            public void onFailure(retrofit2.Call<FoodCartFinalResponse> call, Throwable t) {

            }
        });
    }

}

