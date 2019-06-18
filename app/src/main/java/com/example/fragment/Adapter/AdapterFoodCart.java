package com.example.fragment.Adapter;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.Activity.CartActivity;
import com.example.fragment.Activity.LoginActivity;
import com.example.fragment.Activity.RegisterActivity;
import com.example.fragment.Model.CountandpriceResponse;
import com.example.fragment.Model.DeleteCartItemResponse;
import com.example.fragment.Model.FoodCartImagesGetResponse;
import com.example.fragment.Model.FoodCartImagesPostResponse;
import com.example.fragment.Model.LoginResponse;
import com.example.fragment.R;
import com.example.fragment.SharedPreferences.UserSessionManager;
import com.example.fragment.api.RetrofitClient;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterFoodCart extends RecyclerView.Adapter<AdapterFoodCart.MyViewHolder> {
    public String email;
    UserSessionManager seesion;

    String id;
    String imgurl;
    String text;
    String amount;
    int lastPosition=0;

TextView totalprice;

    List<FoodCartImagesGetResponse.DataBean> modelFood;
    Context context;
//    private int mintegr=0;
    private String prc1;

    public AdapterFoodCart(List<FoodCartImagesGetResponse.DataBean> modelFood, Context context) {
        this.modelFood = modelFood;
        this.context = context;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img,delete;
        TextView txt;
        TextView txt1;
        TextView tx2;
       // TextView totalprice;
        Button btn1,btn2;
        LinearLayout linearLayout;
        public String minteger;
         String price;
//        CartActivity mn=CartActivityCartActivity;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.foodcartimg);
            txt = (TextView) itemView.findViewById(R.id.textcart);
            txt1 = (TextView) itemView.findViewById(R.id.price);
            tx2 = (TextView) itemView.findViewById(R.id.integercart);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.foodcartbtn);
            btn1=(Button)itemView.findViewById(R.id.incre);
            btn2=(Button)itemView.findViewById(R.id.decre);
            delete= (ImageView) itemView.findViewById(R.id.delete);

            totalprice=(TextView)itemView.findViewById(R.id.ttlprc);

            increaseInteger(btn1);
            decreaseInteger(btn2);
            DeleteInteger(delete);

            seesion=new UserSessionManager(context);
            HashMap<String,String> profile=seesion.getUserDetails();
            email=profile.get("email");


            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            minteger = null;

        }
        private void DeleteInteger(ImageView delete) {
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(id, "onClick: "+id );
                    String qwe=txt.getText().toString().trim();

                    Call<DeleteCartItemResponse> Call= RetrofitClient.getInstance().getApi().Delete(qwe,email);

                    Call.enqueue(new Callback<DeleteCartItemResponse>() {
                        @Override
                        public void onResponse(retrofit2.Call<DeleteCartItemResponse> call, Response<DeleteCartItemResponse> response) {

                            DeleteCartItemResponse defaultResponse = response.body();

                            if ((defaultResponse != null ? defaultResponse.getStatus() : 0) == 1) {
                                String im = defaultResponse.getMessage();
                                Intent intent=new Intent(context,CartActivity.class);
                                context.startActivity(intent);
                                Toast.makeText(context," " + im, Toast.LENGTH_LONG).show();
                            } else if ((defaultResponse != null ? defaultResponse.getStatus() : 0) == 0) {
                                String im = defaultResponse.getMessage();

                                Toast.makeText(context, " " + im, Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onFailure(retrofit2.Call call, Throwable t) {

                        }
                    });

                }
            });
        }


        private void decreaseInteger(Button btn1) {
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int manis= Integer.parseInt(txt1.getText().toString().trim());
                    int cn=Integer.parseInt(tx2.getText().toString().trim());
                    manis=(manis/cn);
                    if (cn>1) {
                        cn--;
                        display(cn,manis);
                    }
//                    else if (cn<1){
//
//
//                    }
                }
            });
        }

        private void increaseInteger(Button btn2) {
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int manis= Integer.parseInt(txt1.getText().toString().trim());
                    int cn=Integer.parseInt(tx2.getText().toString().trim());

                    manis=(manis/cn);
                    if (cn<10) {
                        cn++;
                        display(cn,manis);


                    }
                }
            });


        }
            private void display(final int number, int prc) {
            final String number1= String.valueOf(number);
            String prc1= String.valueOf(prc);
            final int exe=number*prc;

            String qwe=txt.getText().toString().trim();
            Log.e(number1, "display: "+number1);
            Log.e(prc1, "display: "+prc1);
            Log.e(qwe, "display: "+qwe);
            Log.e(email, "display: "+email);
            Call<CountandpriceResponse> Call= RetrofitClient.getInstance().getApi().countandpr(qwe, String.valueOf(exe),number1,email);
            Call.enqueue(new Callback<CountandpriceResponse>() {
                @Override
                public void onResponse(retrofit2.Call<CountandpriceResponse> call, Response<CountandpriceResponse> response) {
                    CountandpriceResponse countandpriceResponse = response.body();
                    if ((countandpriceResponse != null ? countandpriceResponse.getStatus() : 0) == 1) {
                        List<CountandpriceResponse.TotalBean> totalbean=response.body()!=null?response.body().getTotal():null;
                        String im = countandpriceResponse.getMessage();

                       // Toast.makeText(context, ""+im, Toast.LENGTH_SHORT).show();
                        txt1.setText(""+exe);


                        tx2.setText("" + number1);
                        Intent intent=new Intent(context,CartActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent);


//                        id=modelFood.get().getPrice();


                    }

                    else if ((countandpriceResponse != null ? countandpriceResponse.getStatus() : 0) == 0) {
                        String im = countandpriceResponse.getMessage();
                        Toast.makeText(context, ""+im , Toast.LENGTH_SHORT).show();


                    }



                }

                @Override
                public void onFailure(retrofit2.Call<CountandpriceResponse> call, Throwable t) {

                }
            });
        }





    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.foodcart,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterFoodCart.MyViewHolder myViewHolder, final int position) {

        final FoodCartImagesGetResponse.DataBean models= modelFood.get(position);

        myViewHolder.txt.setText(modelFood.get(position).getText());
        myViewHolder.txt1.setText(modelFood.get(position).getPrice());
        myViewHolder.tx2.setText(modelFood.get(position).getCount());
        Picasso.get().load(modelFood.get(position).getImage()).into(myViewHolder.img);


    }

@Override
public int getItemCount() {
        return modelFood.size();
        }
        }
















