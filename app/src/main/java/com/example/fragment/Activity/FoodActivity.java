package com.example.fragment.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fragment.Adapter.AdapterFoodCart;
import com.example.fragment.Adapter.ModelAdapter;
//import com.example.fragment.Adapter.ModelAdapter1;
import com.example.fragment.Model.DrinkImageResponse;
import com.example.fragment.Model.FoodCartImagesGetResponse;
import com.example.fragment.Model.FoodCartImagesPostResponse;
import com.example.fragment.Model.FoodImageResponse;
import com.example.fragment.Model.ProductModel;
import com.example.fragment.R;
import com.example.fragment.SharedPreferences.UserSessionManager;
import com.example.fragment.api.RetrofitClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodActivity extends AppCompatActivity {

    ImageView img,txthome;

    RecyclerView rv;
    ModelAdapter adapter1;
    UserSessionManager session;
    RecyclerView rv1;
    String emails;

    //ModelAdapter1 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        /*ACTION BAR*/
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action2);
        img = (ImageView) findViewById(R.id.back);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


        session=new UserSessionManager(this);
        HashMap<String,String> profile=session.getUserDetails();
        emails=profile.get("email");


        /*ACTION to HOME*/
        txthome = (ImageView) findViewById(R.id.cart1);
        txthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<FoodCartImagesGetResponse> Call= RetrofitClient.getInstance().getApi().requestFoodCart(emails);

                Call.enqueue(new Callback<FoodCartImagesGetResponse>() {
                    @Override
                    public void onResponse(retrofit2.Call<FoodCartImagesGetResponse> call, Response<FoodCartImagesGetResponse> response) {
                        FoodCartImagesGetResponse foodCartImagesGetResponse=response.body();
                        if ((foodCartImagesGetResponse!=null? foodCartImagesGetResponse.getStatus():0)==1){

                            Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                            startActivity(intent);
                        }

                    }

                    @Override
                    public void onFailure(retrofit2.Call<FoodCartImagesGetResponse> call, Throwable t) {


                        Intent intent=new Intent(FoodActivity.this,CartEmptyActivity.class);
                        startActivity(intent);
                    }
                });


            }
        });


        rv = (RecyclerView) findViewById(R.id.gridview);
        data();
        rv1 = (RecyclerView) findViewById(R.id.gridview1);

        data1();

    }

    public void data() {
        Call<FoodImageResponse> Call = RetrofitClient.getInstance().getApi().requestFood();

        Call.enqueue(new Callback<FoodImageResponse>() {
            @Override
            public void onResponse(retrofit2.Call<FoodImageResponse> call, Response<FoodImageResponse> response) {
                FoodImageResponse foodImageResponse = response.body();

                if ((foodImageResponse != null ? foodImageResponse.getStatus() : 0) == 1) {

                    List<FoodImageResponse.DataBean> dataBeans = response.body() != null ? response.body().getData() : null;
                    ArrayList<ProductModel> productModels = new ArrayList<>();

                    for (FoodImageResponse.DataBean dataBean : dataBeans){
                        productModels.add(new ProductModel(dataBean.getImage(),dataBean.getText(),dataBean.getPrice(),dataBean.getId()));
                    }


                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    rv.setLayoutManager(mLayoutManager);
                    rv.setItemAnimator(new DefaultItemAnimator());
                    adapter1 = new ModelAdapter(productModels, getApplicationContext());
                    rv.setAdapter(adapter1);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<FoodImageResponse> call, Throwable t) {

            }
        });


    }

    public void data1() {


        Call<DrinkImageResponse> Call = RetrofitClient.getInstance().getApi().requestDrink();

        Call.enqueue(new Callback<DrinkImageResponse>() {
            @Override
            public void onResponse(retrofit2.Call<DrinkImageResponse> call, Response<DrinkImageResponse> response) {
                DrinkImageResponse drinkImageResponse = response.body();

                if ((drinkImageResponse != null ? drinkImageResponse.getStatus() : 0) == 1) {

                    List<DrinkImageResponse.DataBean> dataBeans = response.body() != null ? response.body().getData() : null;
                    ArrayList<ProductModel> productModels = new ArrayList<>();

                    for (DrinkImageResponse.DataBean dataBean : dataBeans){
                        productModels.add(new ProductModel(dataBean.getImage(),dataBean.getText(),dataBean.getPrice(),dataBean.getId()));
                    }

                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    rv1.setLayoutManager(mLayoutManager);
                    rv1.setItemAnimator(new DefaultItemAnimator());
                    adapter1 = new ModelAdapter(productModels, getApplicationContext());
                    rv1.setAdapter(adapter1);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<DrinkImageResponse> call, Throwable t) {

            }
        });


    }
}
