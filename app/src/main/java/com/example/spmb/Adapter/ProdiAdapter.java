package com.example.spmb.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.spmb.Model.Prodi;

public class ProdiAdapter extends ArrayAdapter<Prodi> {
    private Context context;
    private Prodi[] myObjs;

    public ProdiAdapter(Context context, int textViewResourceId,
                         Prodi[] myObjs) {
        super(context, textViewResourceId, myObjs);
        this.context = context;
        this.myObjs = myObjs;
    }

    public int getCount(){
        return myObjs.length;
    }

    public Prodi getItem(int position){
        return myObjs[position];
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs[position].getNamaProdi());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs[position].getNamaProdi());
        return label;
    }
}