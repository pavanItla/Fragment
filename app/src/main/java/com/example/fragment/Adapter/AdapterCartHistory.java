package com.example.fragment.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragment.Model.FoodCartFinalResponse;
import com.example.fragment.R;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AdapterCartHistory extends RecyclerView.Adapter<AdapterCartHistory.MyViewHolder> {

    List<FoodCartFinalResponse.DataBean> model;
    Context context;

    public AdapterCartHistory(List<FoodCartFinalResponse.DataBean> model,Context context){

        this.model=model;
        this.context=context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt1,txt2,txt3,txt4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt1=(TextView) itemView.findViewById(R.id.ordername);
            txt2=(TextView) itemView.findViewById(R.id.count);
            txt3=(TextView) itemView.findViewById(R.id.totalprice);
            txt4=(TextView) itemView.findViewById(R.id.cartemail);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.food_cart_booking_final,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  AdapterCartHistory.MyViewHolder myViewHolder, int i) {

        final FoodCartFinalResponse.DataBean models=model.get(i);

        myViewHolder.txt1.setText(models.getText());
        myViewHolder.txt2.setText(models.getCount());
        myViewHolder.txt3.setText(models.getPrice());
        myViewHolder.txt4.setText(models.getEmail());

    }

    @Override
    public int getItemCount() {
        return model.size();
    }
}
