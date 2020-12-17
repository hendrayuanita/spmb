package com.example.spmb.Rest;
import com.example.spmb.Model.GetBidang;
import com.example.spmb.Model.GetJalur;
import com.example.spmb.Model.GetJurusan;
import com.example.spmb.Model.GetKabupaten;
import com.example.spmb.Model.GetProdi;
import com.example.spmb.Model.GetProvinsi;
import com.example.spmb.Model.GetSekJenis;
import com.example.spmb.Model.GetSekolah;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("propinsi/data/format/json?aktif=1")
    @Headers({"Accept: application/json"})
    Call<GetProvinsi> GetProvinsi();

    @GET("kabupaten/data/format/json?aktif=1")
    @Headers({"Accept: application/json"})
    Call<GetKabupaten> GetKabupaten(@Query("fk_prop") String id);

    @GET("jenis_sekolah/data/format/json?aktif=1")
    @Headers({"Accept: application/json"})
    Call<GetSekJenis> GetSekJenis();

    @GET("sekolah/data/format/json?aktif=1")
    @Headers({"Accept: application/json"})
    Call<GetSekolah> GetSekolah(@Query("fk_jenis") String id, @Query("fk_kabupaten") String id_kab);

    @GET("jurusan_sekolah/data/format/json?aktif=1")
    @Headers({"Accept: application/json"})
    Call<GetJurusan> GetJurusan(@Query("fk_jenis") String id);

    @GET("bidang/data/format/json?mode=C")
    @Headers({"Accept: application/json"})
    Call<GetBidang> GetBidang(@Query("jenisSekolahAsal") String id);

    @GET("seting_jalur/data/format/json?aktif=1&joinparent=true")
    @Headers({"Accept: application/json"})
    Call<GetJalur> GetJalur();

    @GET("seting_prodi/data/format/json?aktif=1")
    @Headers({"Accept: application/json"})
    Call<GetProdi> GetProdi(@Query("fk_jurusanAsal") String jurusanAsal,@Query("fk_jalurMasuk") String fk_jalurMasuk);
}