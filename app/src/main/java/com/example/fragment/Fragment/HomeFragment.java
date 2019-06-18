package com.example.fragment.Fragment;

import android.animation.ArgbEvaluator;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment.Adapter.Adapter1;
import com.example.fragment.Model.Model;
import com.example.fragment.R;


import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment  {

CardView cardView;
ViewPager viewPager;
Adapter1 adapter;
List<Model> models;
Integer[] colors=null;
ArgbEvaluator argbEvaluator=new ArgbEvaluator();

    @Nullable
    @Override

    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        models=new ArrayList<>();
        models.add(new Model(R.drawable.hg,"Hotels","Brochure is an informative paper document (often also used for advertising) that can be folded into a template"));
        models.add(new Model(R.drawable.hb,"Bike Rentals","Brochure is an informative paper document (often also used for advertising) that can be folded into a template"));
        models.add(new Model(R.drawable.hf,"Order Food","Brochure is an informative paper document (often also used for advertising) that can be folded into a template"));
        models.add(new Model(R.drawable.cb,"Car Rental","Brochure is an informative paper document (often also used for advertising) that can be folded into a template"));



        adapter=new Adapter1(models, getActivity());
        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };



        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return  view;
//        adapter=new Adapter1(models,this);

    }
}
