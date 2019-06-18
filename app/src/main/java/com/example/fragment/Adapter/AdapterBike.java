package com.example.fragment.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragment.Activity.BookbikeActivity;
import com.example.fragment.Model.BikeImageResponse;
import com.example.fragment.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterBike extends RecyclerView.Adapter<AdapterBike.MyViewHolder> {

    String id,imgurl,text,price;
    List<BikeImageResponse.DataBean> modelBikes;
    Context context;

    public AdapterBike(List<BikeImageResponse.DataBean> modelBikes, Context context) {
        this.modelBikes = modelBikes;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        Button btn;
        TextView price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img=(ImageView)itemView.findViewById(R.id.imgbike);
            txt=(TextView) itemView.findViewById(R.id.textbike);
            btn=(Button)itemView.findViewById(R.id.bbtnn);
            price=(TextView)itemView.findViewById(R.id.bikeprice);


        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.bike,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        final BikeImageResponse.DataBean models= modelBikes.get(i);

        myViewHolder.txt.setText(modelBikes.get(i).getText());
        myViewHolder.price.setText(modelBikes.get(i).getPrice());

        Picasso.get().load(modelBikes.get(i).getImage()).into(myViewHolder.img);

        myViewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id=modelBikes.get(i).getId();
                text=modelBikes.get(i).getText();
                imgurl=modelBikes.get(i).getImage();
                Intent intent=new Intent(context, BookbikeActivity.class);
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
        return modelBikes.size();
    }
}
