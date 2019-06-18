package com.example.fragment.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragment.Model.BikeResponse;
import com.example.fragment.Model.CarResponse;
import com.example.fragment.R;

import java.util.List;

public class AdapterBikeBooking extends RecyclerView.Adapter<AdapterBikeBooking.MyViewHolder> {

    List<BikeResponse.DataBean> modellisst;
    Context mcontext;

    public AdapterBikeBooking(List<BikeResponse.DataBean> modellisst, Context mcontext) {
        this.modellisst = modellisst;
        this.mcontext = mcontext;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt1 = (TextView) itemView.findViewById(R.id.name);
            txt2 = (TextView) itemView.findViewById(R.id.no);
            txt3 = (TextView) itemView.findViewById(R.id.pick);
            txt4 = (TextView) itemView.findViewById(R.id.drop);
            txt5 = (TextView) itemView.findViewById(R.id.time);
            txt6 = (TextView) itemView.findViewById(R.id.persons);
            txt7 = (TextView) itemView.findViewById(R.id.end);


        }
    }

    @NonNull
    @Override
    public AdapterBikeBooking.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(mcontext).inflate(R.layout.bike_booking_final,viewGroup,false);

        return new AdapterBikeBooking.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBikeBooking.MyViewHolder myViewHolder, int i) {

        final BikeResponse.DataBean model=modellisst.get(i);

        myViewHolder.txt1.setText(model.getName_On_Driving_License());
        myViewHolder.txt2.setText(model.getDriving_License_No());
        myViewHolder.txt3.setText(model.getMobile_No());
        myViewHolder.txt4.setText(model.getDate());
        myViewHolder.txt5.setText(model.getPick_Up_Point());
        myViewHolder.txt6.setText(model.getStart_Time());
        myViewHolder.txt7.setText(model.getEnd_Time());


    }

    @Override
    public int getItemCount() {
        return modellisst.size();
    }
}
