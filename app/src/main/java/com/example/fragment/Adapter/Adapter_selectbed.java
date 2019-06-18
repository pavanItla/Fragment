package com.example.fragment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fragment.Model.Model_selectbed;
import com.example.fragment.R;

import java.util.List;

public class Adapter_selectbed extends BaseAdapter {
    List<Model_selectbed> mod_cr;
    Context mContext;

    public Adapter_selectbed(List<Model_selectbed> mod_cr, Context mContext) {
        this.mod_cr = mod_cr;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {

        return mod_cr.size();
    }

    @Override
    public Object getItem(int position) {
        return mod_cr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(mContext).inflate(R.layout.selectbed_snip,parent,false);

        TextView mn=(TextView)convertView.findViewById(R.id.cr_snip1);

        mn.setText(mod_cr.get(position).getName1());
        return convertView;
    }
}
