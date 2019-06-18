package com.example.fragment.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragment.Model.CarBookingResponse;
import com.example.fragment.Model.CarResponse;
import com.example.fragment.R;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterCarBooking  extends RecyclerView.Adapter<AdapterCarBooking.MyViewHolder> {

    List<CarResponse.DataBean> modellisst;
    Context mcontext;


    public AdapterCarBooking(List<CarResponse.DataBean> modellisst, Context mcontext) {
        this.modellisst = modellisst;
        this.mcontext = mcontext;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt1,txt2,txt3,txt4,txt5,txt6;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt1=(TextView) itemView.findViewById(R.id.name);
            txt2=(TextView) itemView.findViewById(R.id.no);
            txt3=(TextView) itemView.findViewById(R.id.pick);
            txt4=(TextView) itemView.findViewById(R.id.drop);
            txt5=(TextView) itemView.findViewById(R.id.time);
            txt6=(TextView) itemView.findViewById(R.id.persons);
        }
    }

    @NonNull
    @Override
    public AdapterCarBooking.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(mcontext).inflate(R.layout.car_booking_final,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCarBooking.MyViewHolder myViewHolder, int i) {

        final CarResponse.DataBean model=modellisst.get(i);

        myViewHolder.txt1.setText(model.getName());
        myViewHolder.txt2.setText(model.getMobile_no());
        myViewHolder.txt3.setText(model.getPick_up_point());
        myViewHolder.txt4.setText(model.getDrop_off_point());
        myViewHolder.txt5.setText(model.getStart_time());
        myViewHolder.txt6.setText(model.getNo_of_persons());
    }

    @Override
    public int getItemCount() {
        return modellisst.size();
    }
}
