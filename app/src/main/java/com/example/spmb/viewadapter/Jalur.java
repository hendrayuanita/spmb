package com.example.spmb.viewadapter;

import java.io.Serializable;

public class Jalur implements Serializable {
    private String id,namaJalur,fk_jalur,singkatan,tahunAkademik,webPendaftaran;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFk_jalur() {
        return fk_jalur;
    }

    public void setFk_jalur(String fk_jalur) {
        this.fk_jalur = fk_jalur;
    }

    public String getNamaJalur() {
        return namaJalur;
    }

    public void setNamaJalur(String namaJalur) {
        this.namaJalur = namaJalur;
    }

    public String getSingkatan() {
        return singkatan;
    }

    public void setSingkatan(String singkatan) {
        this.singkatan = singkatan;
    }

    public String getTahunAkademik() {
        return tahunAkademik;
    }

    public void setTahunAkademik(String tahunAkademik) {
        this.tahunAkademik = tahunAkademik;
    }

    public String getWebPendaftaran() {
        return webPendaftaran;
    }

    public void setWebPendaftaran(String webPendaftaran) {
        this.webPendaftaran = webPendaftaran;
    }
}
