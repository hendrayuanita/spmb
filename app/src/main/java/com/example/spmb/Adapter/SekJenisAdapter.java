package com.example.spmb.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.spmb.Model.SekJenis;

public class SekJenisAdapter extends ArrayAdapter<SekJenis> {
    private Context context;
    private SekJenis[] myObjs;

    public SekJenisAdapter(Context context, int textViewResourceId,
                          SekJenis[] myObjs) {
        super(context, textViewResourceId, myObjs);
        this.context = context;
        this.myObjs = myObjs;
    }

    public int getCount(){
        return myObjs.length;
    }

    public SekJenis getItem(int position){
        return myObjs[position];
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs[position].getJenisSekolah());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs[position].getJenisSekolah());
        return label;
    }
}
