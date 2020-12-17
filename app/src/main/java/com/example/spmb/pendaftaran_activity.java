package com.example.spmb;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.HttpResponse;

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

import static com.example.spmb.MainActivity.url;

public class pendaftaran_activity extends Activity implements AdapterView.OnItemSelectedListener{

    String[] sumber = { "-","Radio / TV", "Spanduk / Brosur", "Web Polinema", "Sekolah", "Browsing Internet", "Lain - lain" };
    String[] sAgama = { "ISLAM","PROTESTAN", "KATOLIK", "HINDU", "BUDHA", "KONGHUCHU"};
    String[] golDarah = { "-","A", "B", "O", "AB"};
    Button bt;
    TextView txt;
    EditText namaView;
    EditText nikKtpView;
    EditText nisnView;
    EditText jenisKelaminView;
    EditText tempatLahirView;
    EditText tanggalLahirView;
    EditText noHpView;
    EditText noHplainView;
    EditText emailView;
    EditText jalurPilihanView;
    String nama;
    String nikKtp;
    String nisn;
    String jenisKelamin;
    String tempatLahir;
    String tanggalLahir;
    String noHp;
    String noHplain;
    String email;
    String jalurPilihan;
    String agama;
    String golonganDarah;
    String sumberBaca;
    Spinner spin2;
    Spinner spin1;
    Spinner spin;

    String username = "p0ztsD4ta";
    String password = "hs68%3gx*";
    private static final String TAG = "MainActivity";

    String responseServer;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_activity);

        Intent intent = getIntent();
        setTitle("SPMB - Politeknik Negeri Malang");

        final Spinner spin = (Spinner) findViewById(R.id.sumber);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, sumber);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {

                sumberBaca=spin.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub)

            }
        });

       final Spinner spin1 = (Spinner) findViewById(R.id.agama);
        spin1.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, sAgama);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(aa1);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {

                agama=spin1.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub)

            }
        });

        final Spinner spin2 = (Spinner) findViewById(R.id.golDarah);
        spin2.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, golDarah);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(aa2);

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {

                golonganDarah=spin2.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub)

            }
        });

        String jalurPilihan = intent.getStringExtra("jalurPilihan");
        EditText editText = (EditText) findViewById(R.id.jalurPendaftaran);
        editText.setText(jalurPilihan);

        namaView = (EditText) findViewById(R.id.nama);
        nikKtpView = (EditText) findViewById(R.id.nikKtp);
        nisnView = (EditText) findViewById(R.id.nisn);
        jenisKelaminView = (EditText) findViewById(R.id.jenisKelamin);
        tempatLahirView = (EditText) findViewById(R.id.tempatLahir);
        tanggalLahirView = (EditText) findViewById(R.id.tanggalLahir);
        noHpView = (EditText) findViewById(R.id.noHp);
        noHplainView = (EditText) findViewById(R.id.noHplain);
        emailView = (EditText) findViewById(R.id.email);

    }

    public void onClick(View view) {
        Intent i = getIntent();
        String id_jalur = i.getStringExtra("fk_jalur");
        Intent intent = new Intent(this, pendidikan.class);
        jalurPilihanView = (EditText) findViewById(R.id.jalurPendaftaran);
        String jalurpilihan2 = jalurPilihanView.getText().toString();
        nama = namaView.getText().toString();
        nikKtp = nikKtpView.getText().toString();
        nisn = nisnView.getText().toString();
        jenisKelamin = jenisKelaminView.getText().toString();
        tempatLahir = tempatLahirView.getText().toString();
        tanggalLahir = tanggalLahirView.getText().toString();
        noHp = noHpView.getText().toString();
        noHplain = noHplainView.getText().toString();
        email = emailView.getText().toString();
        String id_pendaftar = nikKtp+id_jalur;

        intent.putExtra("jalurPilihan2", jalurpilihan2);
        intent.putExtra("fk_jalur", id_jalur);
        intent.putExtra("idPendaftar", id_pendaftar);
        intent.putExtra("nama", nama);
        intent.putExtra("nikKtp", nikKtp);
        intent.putExtra("nisn", nisn);
        intent.putExtra("jenisKelamin", jenisKelamin);
        intent.putExtra("tempatLahir", tempatLahir);
        intent.putExtra("tanggalLahir", tanggalLahir);
        intent.putExtra("noHp", noHp);
        intent.putExtra("noHplain", noHplain);
        intent.putExtra("email", email);
        intent.putExtra("jalurPilihan", jalurpilihan2);
        intent.putExtra("agama", agama);
        intent.putExtra("golonganDarah", golonganDarah);
        intent.putExtra("sumberBaca", sumberBaca);
        startActivity(intent);
//        nama = namaView.getText().toString();
//        nikKtp = nikKtpView.getText().toString();
//        jenisKelamin = jenisKelaminView.getText().toString();
//        tempatLahir = tempatLahirView.getText().toString();
//        tanggalLahir = tanggalLahirView.getText().toString();
//        noHp = noHpView.getText().toString();
//        noHplain = noHplainView.getText().toString();
//        email = emailView.getText().toString();
//        jalurPilihan = jalurPilihanView.getText().toString();
//        Spinner spin = (Spinner) findViewById(R.id.sumber);
//        sumberBaca = spin.getSelectedItem().toString();
//
//        JSONObject post_dict = new JSONObject();
//
//        try {
//            post_dict.put("fk_setingJalur", jalurPilihan);
//            post_dict.put("nisn" , nisn);
//            post_dict.put("nik", nikKtp);
//            post_dict.put("nama", nama);
//            post_dict.put("jenisKelamin", jenisKelamin);
//            post_dict.put("tempatLahir", tempatLahir);
//            post_dict.put("noHp", noHp);
//            post_dict.put("noHp2", noHplain);
//            post_dict.put("email", email);
//
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        if (post_dict.length() > 0) {
//            new SendJsonDataToServer().execute(String.valueOf(post_dict));
//        }

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

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        Toast.makeText(this, "Anda Mengetahui Dari : " + sumber[position],Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    private class SendJsonDataToServer extends AsyncTask <String,String,String>{
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
}