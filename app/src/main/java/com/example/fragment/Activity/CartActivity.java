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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.Adapter.AdapterFoodCart;
import com.example.fragment.Model.FinalFoodCartHistoryResponse;
import com.example.fragment.Model.FoodCartImagesGetResponse;
import com.example.fragment.Model.FoodCartImagesPostResponse;
import com.example.fragment.Model.TotalPriceREsponse;
import com.example.fragment.R;
import com.example.fragment.SharedPreferences.UserSessionManager;
import com.example.fragment.api.RetrofitClient;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity {



    ImageView img,txthome;
    String emails,UserId,id,text,price;
  TextView txt1,totalprice;
    RecyclerView rv;
    AdapterFoodCart adapterFoodCart;
    UserSessionManager session;
    Button Proceed;



//    String price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        txt1=(TextView)findViewById(R.id.price);
        totalprice=(TextView)findViewById(R.id.ttlprc);
        Proceed= findViewById(R.id.proceed);






        session=new UserSessionManager(this);
        HashMap<String,String> profile=session.getUserDetails();
        emails=profile.get("email");
        UserId=profile.get("UserId");

        /*ACTION BAR*/
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action);
        img=(ImageView)findViewById(R.id.back);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // finish();
                Intent intent=new Intent(getApplicationContext(),FoodActivity.class);
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

        rv=findViewById(R.id.foodcart);
        foodcart();
        foodcart1();

    Proceed.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


//        String nmh=totalprice.getText().toString().trim();
//        Intent intent = new Intent(CartActivity.this,PaymentActivity.class);
//        intent.putExtra("price", nmh);
//        startActivity(intent);


        Call<FinalFoodCartHistoryResponse> Call= RetrofitClient.getInstance().getApi().Finalfoodcart(id,text,price,emails,UserId);

        Call.enqueue(new Callback<FinalFoodCartHistoryResponse>() {
            @Override
            public void onResponse(retrofit2.Call<FinalFoodCartHistoryResponse> call, Response<FinalFoodCartHistoryResponse> response) {

                FinalFoodCartHistoryResponse finalFoodCartHistoryResponse = response.body();

                if ((finalFoodCartHistoryResponse != null ? finalFoodCartHistoryResponse.getStatus() : 0) == 1) {
                    String im = finalFoodCartHistoryResponse.getMessage();
                    Toast.makeText(CartActivity.this,"Success" , Toast.LENGTH_SHORT).show();
                } else if ((finalFoodCartHistoryResponse != null ? finalFoodCartHistoryResponse.getStatus() : 0) == 0) {
                    String im = finalFoodCartHistoryResponse.getMessage();
                    Toast.makeText(CartActivity.this, " " + im, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(retrofit2.Call call, Throwable t) {

            }
        });

        String nmh=totalprice.getText().toString().trim();
        Intent intent = new Intent(CartActivity.this,PaymentActivity.class);
        intent.putExtra("price", nmh);
        startActivity(intent);



    }
});



    }


        public  void foodcart(){
        Call<FoodCartImagesGetResponse> Call= RetrofitClient.getInstance().getApi().requestFoodCart(emails);

        Call.enqueue(new Callback<FoodCartImagesGetResponse>() {
            @Override
            public void onResponse(retrofit2.Call<FoodCartImagesGetResponse> call, Response<FoodCartImagesGetResponse> response) {
                FoodCartImagesGetResponse foodCartImagesGetResponse=response.body();
                if ((foodCartImagesGetResponse!=null? foodCartImagesGetResponse.getStatus():0)==1){

                    List<FoodCartImagesGetResponse.DataBean> dataBeans=response.body()!=null?response.body().getData():null;


                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    rv.setLayoutManager(mLayoutManager);
                    rv.setItemAnimator(new DefaultItemAnimator());
                    adapterFoodCart=new AdapterFoodCart(dataBeans,getApplicationContext());
                    rv.setAdapter(adapterFoodCart);
                }

            }

            @Override
            public void onFailure(retrofit2.Call<FoodCartImagesGetResponse> call, Throwable t) {
//                int im = foodCartImagesGetResponse.getStatus();
//                Toast.makeText(CartActivity.this, "" + im, Toast.LENGTH_LONG).show();

                Intent intent=new Intent(CartActivity.this,CartEmptyActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);
            }
        });



    }


    public void foodcart1(){




        Call<TotalPriceREsponse> Call= RetrofitClient.getInstance().getApi().total(emails);
        Call.enqueue(new Callback<TotalPriceREsponse>() {
            @Override
            public void onResponse(retrofit2.Call<TotalPriceREsponse> call, Response<TotalPriceREsponse> response) {
                TotalPriceREsponse countandpriceResponse = response.body();
                if ((countandpriceResponse != null ? countandpriceResponse.getStatus() : 0) == 1) {
                    List<TotalPriceREsponse.DataBean> dataBean=response.body() !=null ? response.body().getData():null;
                    String im = countandpriceResponse.getMessage();




                        for (TotalPriceREsponse.DataBean mn : dataBean) {

                             totalprice.setText(mn.getPrice());



                        }




                }

                else if ((countandpriceResponse != null ? countandpriceResponse.getStatus() : 0) == 0) {
                    String im = countandpriceResponse.getMessage();
                }



            }

            @Override
            public void onFailure(retrofit2.Call<TotalPriceREsponse> call, Throwable t) {

            }
        });}

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



