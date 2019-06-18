package com.example.fragment.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragment.Activity.BedBookingHistoryActivity;
import com.example.fragment.Activity.BikeBookingHistoryActivity;
import com.example.fragment.Activity.CarBookingHistoryActivity;
import com.example.fragment.Activity.CartHistoryActivity;
import com.example.fragment.Adapter.AdapterCarBooking;
import com.example.fragment.Model.CarResponse;
import com.example.fragment.R;
import com.example.fragment.SharedPreferences.UserSessionManager;
import com.example.fragment.api.Api;
import com.example.fragment.api.RetrofitClient;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingFragment extends Fragment {

     Button btn,btn1,btn2,btn3;

    @Nullable
    @Override

    public View onCreateView( final LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      final  View view= inflater.inflate(R.layout.fragment_book, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
      btn=(Button)view.findViewById(R.id.carbooking);
      btn1=(Button)view.findViewById(R.id.bikebooking);
      btn2=(Button)view.findViewById(R.id.bedbooking);
      btn3=(Button)view.findViewById(R.id.cartbooking);

      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(getActivity(), CarBookingHistoryActivity.class);
              startActivity(intent);

          }
      });

      btn1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent1=new Intent(getActivity(), BikeBookingHistoryActivity.class);
              startActivity(intent1);
          }
      });


btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent2=new Intent(getActivity(), BedBookingHistoryActivity.class);
        startActivity(intent2);
    }
});

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(getActivity(), CartHistoryActivity.class);
                startActivity(intent3);
            }
        });

        return view;
    }


}
