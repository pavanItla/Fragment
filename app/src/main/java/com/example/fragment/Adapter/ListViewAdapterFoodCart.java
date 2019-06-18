

package com.example.fragment.Adapter;

import android.content.Context;
import android.provider.DocumentsContract;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.Activity.RegisterActivity;
import com.example.fragment.Model.CountModel;
import com.example.fragment.Model.FoodCartImagesGetResponse;
import com.example.fragment.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapterFoodCart extends BaseAdapter {


    List<CountModel> modelFood;
    Context mContext;
    ImageView img;
    TextView txt;
    TextView txt1, tx2;
    Button btn1, btn2;
    LinearLayout linearLayout;
    int myCount=1;




    public ListViewAdapterFoodCart(List<CountModel> modelFood, Context mContext) {
        this.modelFood = modelFood;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return modelFood.size();
    }

    @Override
    public Object getItem(int position) {
        return modelFood.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final View view = LayoutInflater.from(mContext).inflate(R.layout.foodcart, parent, false);


        final CountModel models = modelFood.get(position);

        img = (ImageView) view.findViewById(R.id.foodcartimg);
        txt = (TextView) view.findViewById(R.id.textcart);
        txt1 = (TextView) view.findViewById(R.id.price);


        tx2 = (TextView) view.findViewById(R.id.integercart);
        linearLayout = (LinearLayout) view.findViewById(R.id.foodcartbtn);
        btn1 = (Button) view.findViewById(R.id.incre);
        btn2 = (Button) view.findViewById(R.id.decre);


        models.setCount(myCount);
        myCount = models.getCount();
        final int globalpos=position;

        txt.setText(modelFood.get(position).getItemName());
        txt1.setText(modelFood.get(position).getPrice());

        Picasso.get().load(modelFood.get(position).getImage()).into(img);
        tx2.setText(String.valueOf(myCount));




        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myCount != 0) {


                    myCount--;
                    modelFood.get(globalpos).setCount(myCount);
                    tx2.setText(String.valueOf(myCount)); //update the count

//                    tx2.setText(String.valueOf(myCount--));
//                    System.out.println("decrease method count = " + models.getCount());
                }

//                models.set(position, myCount--);
//                tx2.setText(String.valueOf(models.getCount()));

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
//                tx2.setText(String.valueOf(myCount++));
//
//                System.out.println("count = " + models.getCount());
//
                myCount++;
                modelFood.get(globalpos).setCount(myCount);
                tx2.setText(String.valueOf(myCount)); //update the count


//                models.set(position, myCount++);
//                tx2.setText(String.valueOf(models.getCount()));

            }

        });

        return view;


    }


}


