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

import com.example.fragment.Activity.BookcarActivity;
import com.example.fragment.Activity.SelectbedActivity;
import com.example.fragment.Model.BedImageResponse;
import com.example.fragment.Model.CarImageResponse;
import com.example.fragment.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterBed extends RecyclerView.Adapter<AdapterBed.MyViewHolder> {

    List<BedImageResponse.DataBean> modelCars;
    Context context;
    String id,imgurl,text,text1;

    public AdapterBed(List<BedImageResponse.DataBean> modelCars, Context context) {
        this.modelCars = modelCars;
        this.context = context;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt,txt1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img=(ImageView)itemView.findViewById(R.id.bedimg1);
            txt=(TextView) itemView.findViewById(R.id.bedtxt1);
            txt1=(TextView) itemView.findViewById(R.id.bedtxt2);



        }
    }

    @NonNull
    @Override
    public AdapterBed.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.dbbed,viewGroup,false);
        return new AdapterBed.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBed.MyViewHolder myViewHolder, final int i) {
        final BedImageResponse.DataBean models=modelCars.get(i);

        myViewHolder.txt.setText(modelCars.get(i).getText());
//        myViewHolder.txt1.setText(modelCars.get(i).getAddress());

        Picasso.get().load(modelCars.get(i).getImage()).into(myViewHolder.img);


        myViewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id=modelCars.get(i).getId();
                text=modelCars.get(i).getText();
                text1=modelCars.get(i).getAddress();
                imgurl=modelCars.get(i).getImage();
                Intent intent=new Intent(context, SelectbedActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("text",text);
                intent.putExtra("address",text1);
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


