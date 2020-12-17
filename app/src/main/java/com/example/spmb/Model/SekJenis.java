package com.example.spmb.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SekJenis implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("jenisSekolah")
    @Expose
    private String jenisSekolah;
    @SerializedName("d3")
    @Expose
    private String d3;
    @SerializedName("d4")
    @Expose
    private String d4;
    @SerializedName("s2")
    @Expose
    private String s2;
    private final static long serialVersionUID = -2400787888511130648L;

    public SekJenis(String id, String JenisSekolah) {
        this.id = id;
        this.jenisSekolah = JenisSekolah;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJenisSekolah() {
        return jenisSekolah;
    }

    public void setJenisSekolah(String jenisSekolah) {
        this.jenisSekolah = jenisSekolah;
    }

    public String getD3() {
        return d3;
    }

    public void setD3(String d3) {
        this.d3 = d3;
    }

    public String getD4() {
        return d4;
    }

    public void setD4(String d4) {
        this.d4 = d4;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

}