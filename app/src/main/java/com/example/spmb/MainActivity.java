package com.example.spmb;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spmb.viewadapter.Jalur;
import com.example.spmb.viewadapter.JalurRecycle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements JalurRecycle.ItemClickListener {

    private RecyclerView recyclerView;
    private JalurRecycle adapter;
    private String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView lv;
    private TextView empty;

    // URL to get contacts JSON
    public static String url = "https://spmb-devel.polinema.ac.id/api/seting_jalur/data/format/json?aktif=1&joinparent=true";

    ArrayList<Jalur> jalurList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SPMB - Politeknik Negeri Malang");
        empty = (TextView) findViewById(R.id.empty);
        recyclerView = (RecyclerView) findViewById(R.id.jalurRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        jalurList = new ArrayList<>();

        new GetArrData().execute();

    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetArrData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Memproses . . . ");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Respon dari url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // mengambil array JSON node
                    JSONArray arr_data = jsonObj.getJSONArray("arr_data");
                    if(arr_data.length()==0){
                        empty.setText("Tidak Ada Jalur Yang Terbuka");
                    }
                    // looping
                    for (int i = 0; i < arr_data.length(); i++) {
                        JSONObject c = arr_data.getJSONObject(i);

                        String id = c.getString("id");
                        String namaJalur = c.getString("namaJalur");
                        String singkatan = c.getString("singkatan");
                        String fk_jalur = c.getString("fk_jalur");
                        String tahunAkademik = c.getString("tahunAkademik");
                        String webPendaftaran = c.getString("webPendaftaran");

                        // Class
                        Jalur jalur=new Jalur();
                        // adding each child node to HashMap key => value
                        jalur.setId(id);
                        jalur.setNamaJalur(namaJalur);
                        jalur.setSingkatan(singkatan);
                        jalur.setTahunAkademik(tahunAkademik);
                        jalur.setFk_jalur(fk_jalur);
                        jalur.setWebPendaftaran(webPendaftaran);

                        // menambahkan jalur ke jalurList
                        jalurList.add(jalur);
                    }

                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Tidak dapat mendapatkan JSON dari server");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Tidak dapat mendapatkan JSON dari server. Cek Logcat untuk error !",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
//            .setEmptyView(findViewById(R.id.empty));

            adapter = new JalurRecycle(MainActivity.this,jalurList);
            adapter.setClickListener(MainActivity.this);
            recyclerView.setAdapter(adapter);

//          ListAdapter adapter = new SimpleAdapter(
//          MainActivity.this, jalurList,
//          R.layout.list_item, new String[]{"singkatan",
//          "tahunAkademik","webPendaftaran","namaJalur"}, new int[]{R.id.singkatan, R.id.tahunAkademik, R.id.webPendaftaran,
//          R.id.judulButton});

//          lv.setAdapter(adapter);
        }

    }
}