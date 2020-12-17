package com.example.spmb.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Provinsi implements Serializable
{
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("kodeSiakad")
    @Expose
    private String kodeSiakad;
    @SerializedName("namaProp")
    @Expose
    private String namaProp;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("aktif")
    @Expose
    private String aktif;
    private final static long serialVersionUID = -1678366521722684077L;

    public Provinsi(String id, String namaProp) {
        this.id = id;
        this.namaProp = namaProp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Provinsi withId(String id) {
        this.id = id;
        return this;
    }

    public String getKodeSiakad() {
        return kodeSiakad;
    }

    public void setKodeSiakad(String kodeSiakad) {
        this.kodeSiakad = kodeSiakad;
    }

    public Provinsi withKodeSiakad(String kodeSiakad) {
        this.kodeSiakad = kodeSiakad;
        return this;
    }

    public String getNamaProp() {
        return namaProp;
    }

    public void setNamaProp(String namaProp) {
        this.namaProp = namaProp;
    }

    public Provinsi withNamaProp(String namaProp) {
        this.namaProp = namaProp;
        return this;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Provinsi withKeterangan(String keterangan) {
        this.keterangan = keterangan;
        return this;
    }

    public String getAktif() {
        return aktif;
    }

    public void setAktif(String aktif) {
        this.aktif = aktif;
    }

    public Provinsi withAktif(String aktif) {
        this.aktif = aktif;
        return this;
    }



}