package com.example.spmb;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.spmb.Adapter.BidangAdapter;
import com.example.spmb.Adapter.JurusanAdapter;
import com.example.spmb.Adapter.KabupatenAdapter;
import com.example.spmb.Adapter.ProdiAdapter;
import com.example.spmb.Adapter.ProvinsiAdapter;
import com.example.spmb.Adapter.SekJenisAdapter;
import com.example.spmb.Adapter.SekolahAdapter;
import com.example.spmb.Model.Bidang;
import com.example.spmb.Model.GetBidang;
import com.example.spmb.Model.GetJurusan;
import com.example.spmb.Model.GetKabupaten;
import com.example.spmb.Model.GetProdi;
import com.example.spmb.Model.GetProvinsi;
import com.example.spmb.Model.GetSekJenis;
import com.example.spmb.Model.GetSekolah;
import com.example.spmb.Model.Jurusan;
import com.example.spmb.Model.Kabupaten;
import com.example.spmb.Model.Prodi;
import com.example.spmb.Model.Provinsi;
import com.example.spmb.Model.SekJenis;
import com.example.spmb.Model.Sekolah;
import com.example.spmb.Rest.ApiClient;
import com.example.spmb.Rest.ApiInterface;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pendidikan extends AppCompatActivity {
    Spinner sProvinsi;
    Spinner sKabupaten;
    String id_sekolah;
    String id_provinsi;
    String id_kabupaten;
    String id_jenis;
    String id_jurusan;
    String id_jalur;
    String id_prodi;
    Spinner sSekJenis;
    Spinner sSekolah;
    Spinner sJurusan;
    Spinner sBidang;
    Spinner sProdi;
    String itemBidang;
//    String id_mode;
    private Button mybutton;
    private Button mybutton1;
    String username = "p0ztsD4ta";
    String password = "hs68%3gx*";
    private static final String TAG = "MainActivity";
    ApiInterface mApiProvinsi,mApiKabupaten,mApiSekJenis,mApiSekolah, mApiJurusan, mApiBidang, mApiSeting_prodi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendidikan);

        Intent intent = getIntent();
        String jalurPilihan2 = intent.getStringExtra("jalurPilihan");
        id_jalur = intent.getStringExtra("fk_jalur");
        mybutton = (Button)findViewById(R.id.kembali);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        sProvinsi = (Spinner) findViewById(R.id.spinner2);
        sKabupaten = (Spinner) findViewById(R.id.spinner3);
        sSekJenis= (Spinner) findViewById(R.id.spinner4);
        sSekolah = (Spinner) findViewById(R.id.spinner5);
        sJurusan = (Spinner) findViewById(R.id.spinner6);
        sBidang = (Spinner) findViewById(R.id.spinner7);
        sProdi = (Spinner) findViewById(R.id.spinner8);
        initProvinsi();
        initSekJenis();

    }

    public void onClick(View view) {
        Intent i = getIntent();
        String id_pendaftar = i.getStringExtra("idPendaftar");
        String nama = i.getStringExtra("nama");
        String nikKtp = i.getStringExtra("nikKtp");
        String nisn = i.getStringExtra("nisn");
        String jenisKelamin = i.getStringExtra("jenisKelamin");
        String tempatLahir = i.getStringExtra("tempatLahir");
        String tanggalLahir = i.getStringExtra("tanggalLahir");
        String noHp = i.getStringExtra("noHp");
        String noHplain = i.getStringExtra("noHplain");
        String email = i.getStringExtra("email");
        String agama = i.getStringExtra("agama");
        String golDarah= i.getStringExtra("golonganDarah");
        String sumberBaca = i.getStringExtra("sumberBaca");


        JSONObject post_dict = new JSONObject();

        try {
            post_dict.put("idPendaftar", id_pendaftar);
            post_dict.put("fk_idJlrMskStat", id_prodi);
            post_dict.put("fk_idSekolah", id_sekolah);
            post_dict.put("fk_idjurSekolah", id_jurusan);
            post_dict.put("nisn" , nisn);
            post_dict.put("nikPendaftar", nikKtp);
            post_dict.put("nama", nama);
            post_dict.put("jenisKelamin", jenisKelamin);
            post_dict.put("tempatLahir", tempatLahir);
            post_dict.put("tglLahir", tanggalLahir);
            post_dict.put("noHp", noHp);
            post_dict.put("noHp2", noHplain);
            post_dict.put("email", email);
            post_dict.put("agama", agama);
            post_dict.put("golDarah", golDarah);
            post_dict.put("jenisJurusanReg", itemBidang);
            post_dict.put("infoForm", sumberBaca);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (post_dict.length() > 0) {
            new SendJsonDataToServer().execute(String.valueOf(post_dict));
        }

//        Intent intent = new Intent(this, pendidikan.class);
//        intent.putExtra("fk_jalur", id_jalur);
//        intent.putExtra("idPendaftar", id_pendaftar);
//        intent.putExtra("nama", nama);
//        intent.putExtra("nikKtp", nikKtp);
//        intent.putExtra("nisn", nisn);
//        intent.putExtra("jenisKelamin", jenisKelamin);
//        intent.putExtra("tempatLahir", tempatLahir);
//        intent.putExtra("tanggalLahir", tanggalLahir);
//        intent.putExtra("noHp", noHp);
//        intent.putExtra("noHplain", noHplain);
//        intent.putExtra("email", email);
//        intent.putExtra("agama", agama);
//        intent.putExtra("golonganDarah", golDarah);
//        intent.putExtra("sumberBaca", sumberBaca);
//
//        String provinsi = sProvinsi.getSelectedItem().toString();
//        String kabupaten = sKabupaten.getSelectedItem().toString();
//        String sekjenis = sSekJenis.getSelectedItem().toString();
//        String sekolah = sSekolah.getSelectedItem().toString();
//        String jurusan = sJurusan.getSelectedItem().toString();
//        String prodi = sProdi.getSelectedItem().toString();

    }

    private void initProvinsi() {
        mApiProvinsi = ApiClient.getClient().create(ApiInterface.class);
        Call<GetProvinsi> mKategoriCall = mApiProvinsi.GetProvinsi();

        (mKategoriCall).enqueue(new Callback<GetProvinsi>() {
            @Override
            public void onResponse(Call<GetProvinsi> call, Response<GetProvinsi> response) {
                List<Provinsi> sProvinsiItems = response.body().getArrData();
                Provinsi object[] = new  Provinsi[sProvinsiItems.size()];
                for (int i = 0; i < sProvinsiItems.size(); i++){
                    object[i] = new Provinsi(sProvinsiItems.get(i).getId(), sProvinsiItems.get(i).getNamaProp());
                }

                ProvinsiAdapter adapter2 =
                        new ProvinsiAdapter(pendidikan.this,
                                android.R.layout.simple_spinner_dropdown_item,object);
                //adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sProvinsi.setAdapter(adapter2);
                sProvinsi.setOnItemSelectedListener(onItemSelectedListener2);
            }

            @Override
            public void onFailure(Call<GetProvinsi> call, Throwable t) {
                Log.v("RESPONSE_BODY", String.valueOf(t.getMessage()));
            }
        });
    }

    AdapterView.OnItemSelectedListener onItemSelectedListener2 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    Provinsi obj = (Provinsi) (parent.getItemAtPosition(position));
                    id_provinsi = String.valueOf(obj.getId());
                    initKab(id_provinsi);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    private void initKab(String id_prop){
            mApiKabupaten = ApiClient.getClient().create(ApiInterface.class);
            Call<GetKabupaten> mKabupatencall = mApiKabupaten.GetKabupaten(id_prop);

            mKabupatencall.enqueue(new Callback<GetKabupaten>() {
                @Override
                public void onResponse(Call<GetKabupaten> call, Response<GetKabupaten> response) {
                    List<Kabupaten> kabupatenList = response.body().getArrData();
                    Kabupaten Object[] = new Kabupaten[kabupatenList.size()];
                    for (int i = 0; i < kabupatenList.size(); i++){
                        Object[i] = new Kabupaten(kabupatenList.get(i).getId(), kabupatenList.get(i).getNamaKab());
                    }

                   KabupatenAdapter adapter3 = new KabupatenAdapter(pendidikan.this,
                           android.R.layout.simple_spinner_dropdown_item, Object);
                    //adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sKabupaten.setAdapter(adapter3);
                    sKabupaten.setOnItemSelectedListener(onItemSelectedListener4);

                }

                @Override
                public void onFailure(Call<GetKabupaten> call, Throwable t) {

                }
            });
    }
    AdapterView.OnItemSelectedListener onItemSelectedListener4 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    Kabupaten obj = (Kabupaten) (parent.getItemAtPosition(position));
                    id_kabupaten = String.valueOf(obj.getId());
                    initSekolah(id_kabupaten);
                    initJurusan(id_jenis);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };



    private void initSekJenis() {
        mApiProvinsi = ApiClient.getClient().create(ApiInterface.class);
        Call<GetSekJenis> mKategoriCall = mApiProvinsi.GetSekJenis();

        mKategoriCall.enqueue(new Callback<GetSekJenis>() {
            @Override
            public void onResponse(Call<GetSekJenis> call, Response<GetSekJenis> response) {
                List<SekJenis> listSekJenis = response.body().getArrData();
                SekJenis object[] = new  SekJenis[listSekJenis.size()];
                for (int i = 0; i < listSekJenis.size(); i++){
                    object[i] = new SekJenis(listSekJenis.get(i).getId(), listSekJenis.get(i).getJenisSekolah());
                }

                SekJenisAdapter adapter2 =
                        new SekJenisAdapter(pendidikan.this,
                                android.R.layout.simple_spinner_dropdown_item,object);
                //adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sSekJenis.setAdapter(adapter2);
                sSekJenis.setOnItemSelectedListener(onItemSelectedListener3);
            }

            @Override
            public void onFailure(Call<GetSekJenis> call, Throwable t) {

            }
        });

    }

    AdapterView.OnItemSelectedListener onItemSelectedListener3 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    SekJenis obj = (SekJenis) (parent.getItemAtPosition(position));
                    id_jenis = String.valueOf(obj.getId());
                    initSekolah(id_jenis);
                    initJurusan(id_jenis);

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    private void initSekolah(String id_jenis){
        mApiSekolah = ApiClient.getClient().create(ApiInterface.class);
        Call<GetSekolah> mSekolahcall = mApiSekolah.GetSekolah(id_jenis, id_kabupaten);

        mSekolahcall.enqueue(new Callback<GetSekolah>() {
            @Override
            public void onResponse(Call<GetSekolah> call, Response<GetSekolah> response) {
                List<Sekolah> sekolahList = response.body().getArrData();
                Sekolah Object[] = new Sekolah[sekolahList.size()];
                for (int i = 0; i < sekolahList.size(); i++){
                    Object[i] = new Sekolah(sekolahList.get(i).getId(), sekolahList.get(i).getNama());
                }

                SekolahAdapter adapter3 = new SekolahAdapter(pendidikan.this,
                        android.R.layout.simple_spinner_dropdown_item, Object);
                //adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sSekolah.setAdapter(adapter3);
                sSekolah.setOnItemSelectedListener(onItemSelectedListener6);
            }

            @Override
            public void onFailure(Call<GetSekolah> call, Throwable t) {

            }
        });
            }

    AdapterView.OnItemSelectedListener onItemSelectedListener6 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    Sekolah obj = (Sekolah) (parent.getItemAtPosition(position));
                    id_sekolah = String.valueOf(obj.getId());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    private void initJurusan(String id_jenis){
        mApiJurusan = ApiClient.getClient().create(ApiInterface.class);
        Call<GetJurusan> mJurusancall = mApiJurusan.GetJurusan(id_jenis);

        mJurusancall.enqueue(new Callback<GetJurusan>() {
            @Override
            public void onResponse(Call<GetJurusan> call, Response<GetJurusan> response) {
                List<Jurusan> jurusanList = response.body().getArrData();
                Jurusan Object[] = new Jurusan[jurusanList.size()];
                for (int i = 0; i < jurusanList.size(); i++){
                    Object[i] = new Jurusan(jurusanList.get(i).getId(), jurusanList.get(i).getNamaJurusanAsal());
                }

                JurusanAdapter adapter3 = new JurusanAdapter(pendidikan.this,
                        android.R.layout.simple_spinner_dropdown_item, Object);
                //adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sJurusan.setAdapter(adapter3);
                sJurusan.setOnItemSelectedListener(onItemSelectedListener5);
            }

            @Override
            public void onFailure(Call<GetJurusan> call, Throwable t) {

            }
        });
    }

    AdapterView.OnItemSelectedListener onItemSelectedListener5 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    Jurusan obj = (Jurusan) (parent.getItemAtPosition(position));
                    id_jurusan = String.valueOf(obj.getId());
                    initBidang(id_jurusan);
                    Intent intent = getIntent();
                    String idc = intent.getStringExtra("fk_jalur");
                    initProdi(id_jurusan,idc);

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    private void initBidang(String id_jurusan){
        mApiBidang = ApiClient.getClient().create(ApiInterface.class);
        Call<GetBidang> mBidangcall = mApiBidang.GetBidang(id_jurusan);

        mBidangcall.enqueue(new Callback<GetBidang>() {
            @Override
            public void onResponse(Call<GetBidang> call, Response<GetBidang> response) {
                List<Bidang> bidangList = response.body().getArrData();
                Bidang Object[] = new Bidang[bidangList.size()];
                for (int i = 0; i < bidangList.size(); i++){
                    Object[i] = new Bidang(bidangList.get(i).getId(), bidangList.get(i).getNamaBidang());
                }

                BidangAdapter adapter3 = new BidangAdapter(pendidikan.this,
                        android.R.layout.simple_spinner_dropdown_item, Object);
                //adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sBidang.setAdapter(adapter3);
                sBidang.setOnItemSelectedListener(onItemSelectedListener8);
            }

            @Override
            public void onFailure(Call<GetBidang> call, Throwable t) {

            }
        });
    }

    AdapterView.OnItemSelectedListener onItemSelectedListener8 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    Bidang obj = (Bidang) (parent.getItemAtPosition(position));
                    itemBidang = String.valueOf(obj.getNamaBidang());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    private void initProdi(String id_jurusan,String id_jalur){
        mApiSeting_prodi = ApiClient.getClient().create(ApiInterface.class);
        Call<GetProdi> mProdicall = mApiSeting_prodi.GetProdi(id_jurusan,id_jalur);

        mProdicall.enqueue(new Callback<GetProdi>() {
            @Override
            public void onResponse(Call<GetProdi> call, Response<GetProdi> response) {
                List<Prodi> prodiList = response.body().getArrData();
                Prodi Object[] = new Prodi[prodiList.size()];
                for (int i = 0; i < prodiList.size(); i++){
                    Object[i] = new Prodi(prodiList.get(i).getIdprodiValid(), prodiList.get(i).getNamaProdi());
                }

                ProdiAdapter adapter3 = new ProdiAdapter(pendidikan.this,
                        android.R.layout.simple_spinner_dropdown_item, Object);
                //adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sProdi.setAdapter(adapter3);
                sProdi.setOnItemSelectedListener(onItemSelectedListener7);

            }

            @Override
            public void onFailure(Call<GetProdi> call, Throwable t) {

            }
        });
    }

    AdapterView.OnItemSelectedListener onItemSelectedListener7 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    Prodi obj = (Prodi) (parent.getItemAtPosition(position));
                    id_prodi = String.valueOf(obj.getIdprodiValid());
//                    String item = String.valueOf(parent.getItemAtPosition(position));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    private class SendJsonDataToServer extends AsyncTask<String,String,String> {
        @Override
        protected String doInBackground(String... params) {

            String JsonResponse = null;
            String JsonDATA = params[0];
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            Authenticator.setDefault(new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password.toCharArray());
                }
            });
            try {
                URL url = new URL("https://spmb-devel.polinema.ac.id/api/registrasi/save");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoOutput(true);
                // is output buffer writter
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setRequestProperty("Accept", "application/json");
                //set headers and method
                Writer writer = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
                writer.write(JsonDATA);
                // json data
                writer.close();
                InputStream inputStream = urlConnection.getInputStream();
                //input stream
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String inputLine;
                while ((inputLine = reader.readLine()) != null)
                    buffer.append(inputLine + "\n");
                if (buffer.length() == 0) {
                    // Stream was empty. No point in parsing.
                    return null;
                }
                JsonResponse = buffer.toString();
                //response data
                Log.i(TAG,JsonResponse);
                //send to post execute
                return JsonResponse;

            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(TAG, "Error closing stream", e);
                    }
                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {
        }
    }

    public static class InputStreamToStringExample {

        public static void main(String[] args) throws IOException {

            // intilize an InputStream
            InputStream is =
                    new ByteArrayInputStream("File Content : ".getBytes());

            String result = getStringFromInputStream(is);

            System.out.println(result);
            System.out.println("Selesai");

        }

        // convert InputStream to String
        private static String getStringFromInputStream(InputStream is) {

            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();

            String line;
            try {

                br = new BufferedReader(new InputStreamReader(is));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return sb.toString();
        }

    }
}