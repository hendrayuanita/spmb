package com.example.spmb.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Kabupaten implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("fk_prop")
    @Expose
    private String fkProp;
    @SerializedName("kodeSiakad")
    @Expose
    private String kodeSiakad;
    @SerializedName("namaKab")
    @Expose
    private String namaKab;
    @SerializedName("sumberData")
    @Expose
    private String sumberData;
    @SerializedName("aktif")
    @Expose
    private String aktif;
    private final static long serialVersionUID = -8667411135871282523L;

    public Kabupaten(String id, String namaKab) {
        this.id = id;
        this.namaKab = namaKab;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkProp() {
        return fkProp;
    }

    public void setFkProp(String fkProp) {
        this.fkProp = fkProp;
    }

    public String getKodeSiakad() {
        return kodeSiakad;
    }

    public void setKodeSiakad(String kodeSiakad) {
        this.kodeSiakad = kodeSiakad;
    }

    public String getNamaKab() {
        return namaKab;
    }

    public void setNamaKab(String namaKab) {
        this.namaKab = namaKab;
    }

    public String getSumberData() {
        return sumberData;
    }

    public void setSumberData(String sumberData) {
        this.sumberData = sumberData;
    }

    public String getAktif() {
        return aktif;
    }

    public void setAktif(String aktif) {
        this.aktif = aktif;
    }

}