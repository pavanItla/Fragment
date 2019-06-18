package com.example.fragment.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragment.Model.BedResponse;
import com.example.fragment.Model.BikeResponse;
import com.example.fragment.R;

import java.util.List;

public class AdapterBedBooking extends  RecyclerView.Adapter<AdapterBedBooking.MyViewHolder> {

    List<BedResponse.DataBean> modellisst;
    Context mcontext;

    public AdapterBedBooking(List<BedResponse.DataBean> modellisst, Context mcontext) {
        this.modellisst = modellisst;
        this.mcontext = mcontext;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt1, txt2, txt3, txt4, txt5,txt6,txt7;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt1 = (TextView) itemView.findViewById(R.id.name);
            txt2 = (TextView) itemView.findViewById(R.id.no);
            txt3 = (TextView) itemView.findViewById(R.id.adults);
            txt4 = (TextView) itemView.findViewById(R.id.childs);
            txt5 = (TextView) itemView.findViewById(R.id.date);
            txt6 = (TextView) itemView.findViewById(R.id.typeofbed);
            txt7 = (TextView) itemView.findViewById(R.id.bedaddress);



        }
    }

    @NonNull
    @Override
    public AdapterBedBooking.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(mcontext).inflate(R.layout.bed_booking_final,viewGroup,false);

        return new AdapterBedBooking.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBedBooking.MyViewHolder myViewHolder, int i) {




        final BedResponse.DataBean model=modellisst.get(i);

        myViewHolder.txt1.setText(model.getUsername());
        myViewHolder.txt2.setText(model.getPhoneno());
        myViewHolder.txt3.setText(model.getNoofadults());
        myViewHolder.txt4.setText(model.getNoofchilds());
        myViewHolder.txt5.setText(model.getTypeofbed());
        myViewHolder.txt6.setText(model.getDate());
        myViewHolder.txt7.setText(model.getAddress());


    }

    @Override
    public int getItemCount() {
        return modellisst.size();
    }


}
