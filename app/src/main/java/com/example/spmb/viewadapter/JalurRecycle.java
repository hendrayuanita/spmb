package com.example.spmb.viewadapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import com.example.spmb.MainActivity;
import com.example.spmb.R;
import com.example.spmb.pendaftaran_activity;

import java.util.ArrayList;

//import java.util.List;

public class JalurRecycle extends RecyclerView.Adapter<JalurRecycle.ViewHolder> {
    private LayoutInflater inflater;
    private Context parent;
    private ArrayList<Jalur> data;
    private ItemClickListener mClickListener;
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
    public Jalur getJalur(int id) {
        return data.get(id);
    }
//    public String getNama_gedung(int id) {
//        return data.get(id).getNama_gedung();
//    }
//    public String getMessage(int id) {
//        return data.get(id).getMessage();
//    }
//    public String getMessageDate(int id) {
//        return data.get(id).getMessage_date();
//    }
//    public int getIsRead(int id) {
//        return data.get(id).getIs_read();
//    }
    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
    public JalurRecycle(Context context, ArrayList<Jalur> data){
        parent = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Jalur re = data.get(i);
        viewHolder.singkatan.setText(String.valueOf(re.getNamaJalur()));
        viewHolder.tahunAkademik.setText(String.valueOf(re.getTahunAkademik()));
        viewHolder.webPendaftaran.setText(String.valueOf(re.getWebPendaftaran()));
        viewHolder.namaJalur.setText(String.valueOf(re.getNamaJalur()));
        viewHolder.namaJalur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
//                if(String.valueOf(re.getWebPendaftaran()) !=null){
//                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(re.getWebPendaftaran()));
//                    context.startActivity(browserIntent);
//                }else {
                    Intent intent = new Intent(context, pendaftaran_activity.class);
                    intent.putExtra("jalurPilihan", re.getNamaJalur());
                    intent.putExtra("fk_jalur",re.getFk_jalur());
                    context.startActivity(intent);
//                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener{
        TextView singkatan;
        TextView tahunAkademik;
        TextView webPendaftaran;
        Button namaJalur;
        ViewHolder(View itemView) {
            super(itemView);
            singkatan= (TextView)itemView.findViewById(R.id.singkatan);
            tahunAkademik = (TextView)itemView.findViewById(R.id.tahunAkademik);
            webPendaftaran = (TextView)itemView.findViewById(R.id.webPendaftaran);
            namaJalur = (Button)itemView.findViewById(R.id.judulButton);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v,getAdapterPosition());
        }
    }
}
