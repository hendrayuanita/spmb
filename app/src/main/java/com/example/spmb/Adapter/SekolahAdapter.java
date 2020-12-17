package com.example.spmb.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.spmb.Model.Sekolah;

public class SekolahAdapter extends ArrayAdapter<Sekolah> {
    private Context context;
    private Sekolah[] myObjs;

    public SekolahAdapter(Context context, int textViewResourceId,
                            Sekolah[] myObjs) {
        super(context, textViewResourceId, myObjs);
        this.context = context;
        this.myObjs = myObjs;
    }

    public int getCount(){
        return myObjs.length;
    }

    public Sekolah getItem(int position){
        return myObjs[position];
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs[position].getNama());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs[position].getNama());
        return label;
    }

}
