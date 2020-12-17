package com.example.spmb;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class apikey {
    public static final String BASE_URL = "https://spmb-devel.polinema.ac.id/api/seting_jalur/data/format/json?aktif=1&joinparent=true";
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
