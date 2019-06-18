package com.example.fragment.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragment.Activity.BookcarActivity;
import com.example.fragment.Model.CarImageResponse;
import com.example.fragment.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterCar extends RecyclerView.Adapter<AdapterCar.MyViewHolder> {

    List<CarImageResponse.DataBean> modelCars;
    Context context;
    String id,imgurl,text,fuel,price;

    public AdapterCar(List<CarImageResponse.DataBean> modelCars, Context context) {
        this.modelCars = modelCars;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        TextView fuel;
        TextView price;
        Button btn;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        img=(ImageView)itemView.findViewById(R.id.img);
        txt=(TextView) itemView.findViewById(R.id.text);
        fuel=(TextView) itemView.findViewById(R.id.fuel);
        price=(TextView) itemView.findViewById(R.id.price);
        btn=(Button) itemView.findViewById(R.id.bookcar);


    }
}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.car,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder,final int i) {
        final CarImageResponse.DataBean models=modelCars.get(i);

        myViewHolder.txt.setText(modelCars.get(i).getText());
        myViewHolder.fuel.setText(modelCars.get(i).getFuel());
        myViewHolder.price.setText(modelCars.get(i).getPrice());

        Picasso.get().load(modelCars.get(i).getImage()).into(myViewHolder.img);

        Log.e("DATA",""+modelCars.get(i).getText() +"'"+(modelCars.get(i).getImage()));


        myViewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id=modelCars.get(i).getId();
                text=modelCars.get(i).getText();
                imgurl=modelCars.get(i).getImage();
                Intent intent=new Intent(context, BookcarActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("text",text);
                intent.putExtra("image",imgurl);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);



                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelCars.size();
    }
}
