package com.example.fragment.Adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.Model.FoodCartImagesPostResponse;
import com.example.fragment.Model.ProductModel;
import com.example.fragment.R;
import com.example.fragment.SharedPreferences.UserSessionManager;
import com.example.fragment.api.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MyViewHolder> {


    List<ProductModel> modelFood;
    Context context;
    String id,text,price;
    int count=0;
   // String id1;
String email,Date,UserId;
    UserSessionManager seesion;
    int button;



    public ModelAdapter(List<ProductModel> modelFood, Context context) {
        this.modelFood = modelFood;
        this.context = context;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageview;
        TextView txt;
        TextView txt1;

        Button button;

        public MyViewHolder(@NonNull View itemView){

            super(itemView);

            imageview=(ImageView)itemView.findViewById(R.id.img);
            txt=(TextView)itemView.findViewById(R.id.text);
            txt1=(TextView)itemView.findViewById(R.id.price);
            button=(Button)itemView.findViewById(R.id.angry_btn);

            seesion=new UserSessionManager(context);
            HashMap<String,String> profile=seesion.getUserDetails();
            email=profile.get("email");
            UserId=profile.get("UserId");


        }

    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.food,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {


        final ProductModel models=modelFood.get(i);



        myViewHolder.txt.setText(modelFood.get(i).getName());
        myViewHolder.txt1.setText(modelFood.get(i).getPrice());

        Picasso.get().load(modelFood.get(i).getImage()).into(myViewHolder.imageview);



        myViewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                id=modelFood.get(i).getId();
                text=modelFood.get(i).getName();
                price=modelFood.get(i).getPrice();



                Call<FoodCartImagesPostResponse> Call= RetrofitClient.getInstance().getApi().PostFoodCart(id,text,price,email,UserId);

                Call.enqueue(new Callback<FoodCartImagesPostResponse>() {
                    @Override
                    public void onResponse(retrofit2.Call<FoodCartImagesPostResponse> call, Response<FoodCartImagesPostResponse> response) {

                        FoodCartImagesPostResponse defaultResponse = response.body();

                        if ((defaultResponse != null ? defaultResponse.getStatus() : 0) == 1) {
                            String im = defaultResponse.getMessage();
                            Toast.makeText(context,"Item Added To Cart" +button, Toast.LENGTH_SHORT).show();
                        } else if ((defaultResponse != null ? defaultResponse.getStatus() : 0) == 0) {
                            String im = defaultResponse.getMessage();
                            Toast.makeText(context, " " + im+button, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(retrofit2.Call call, Throwable t) {

                    }
                });

            }
        });
    }

    @Override
    public int getItemCount() {
        return modelFood.size();
    }
}









