package com.example.spmb.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.spmb.Model.Provinsi;


public class ProvinsiAdapter extends ArrayAdapter<Provinsi> {

    private Context context;
    private Provinsi[] myObjs;

    public ProvinsiAdapter(Context context, int textViewResourceId,
                           Provinsi[] myObjs) {
        super(context, textViewResourceId, myObjs);
        this.context = context;
        this.myObjs = myObjs;
    }

    public int getCount(){
        return myObjs.length;
    }

    public Provinsi getItem(int position){
        return myObjs[position];
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs[position].getNamaProp());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs[position].getNamaProp());
        return label;
    }
}

