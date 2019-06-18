package com.example.fragment.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.Activity.BikeActivity;
import com.example.fragment.Activity.BookActivity;
import com.example.fragment.Activity.CarActivtiy;
import com.example.fragment.Activity.DetailActivity;
import com.example.fragment.Activity.FoodActivity;
import com.example.fragment.Activity.ScanActivity;
import com.example.fragment.Activity.SelectbedActivity;
import com.example.fragment.Model.Model;
import com.example.fragment.R;

import java.util.List;

public class Adapter1 extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter1(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView;
        TextView title, desc;

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (position==0){


                    Intent intent = new Intent(context, BookActivity.class);
                    intent.putExtra("param", models.get(position).getTitle());
                    context.startActivity(intent);

                }

                else if (position==1){
                    Intent intent = new Intent(context, BikeActivity.class);
                    intent.putExtra("param", models.get(position).getTitle());
                    context.startActivity(intent);

                }
                else if (position==2){

                    Intent intent = new Intent(context, FoodActivity.class);
                    intent.putExtra("param", models.get(position).getTitle());
                    context.startActivity(intent);
                }
                else if(position==3){
                    Intent intent = new Intent(context, CarActivtiy.class);
                    intent.putExtra("param", models.get(position).getTitle());
                    context.startActivity(intent);
                }
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
