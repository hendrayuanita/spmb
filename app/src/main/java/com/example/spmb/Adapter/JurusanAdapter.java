package com.example.spmb.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.spmb.Model.Jurusan;


public class JurusanAdapter extends ArrayAdapter<Jurusan> {

    private Context context;
    private Jurusan[] myObjs;

    public JurusanAdapter(Context context, int textViewResourceId,
                            Jurusan[] myObjs) {
        super(context, textViewResourceId, myObjs);
        this.context = context;
        this.myObjs = myObjs;
    }

    public int getCount(){
        return myObjs.length;
    }

    public Jurusan getItem(int position){
        return myObjs[position];
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs[position].getNamaJurusanAsal());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs[position].getNamaJurusanAsal());
        return label;
    }
}
