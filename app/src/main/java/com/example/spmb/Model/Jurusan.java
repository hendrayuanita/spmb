package com.example.spmb.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Jurusan implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("fk_jenis")
    @Expose
    private String fkJenis;
    @SerializedName("jenisSekolahAsal")
    @Expose
    private String jenisSekolahAsal;
    @SerializedName("bidangJurusanAsal")
    @Expose
    private String bidangJurusanAsal;
    @SerializedName("namaJurusanAsal")
    @Expose
    private String namaJurusanAsal;
    @SerializedName("ditampilkan")
    @Expose
    private String ditampilkan;
    @SerializedName("keterangan")
    @Expose
    private Object keterangan;
    public final static Creator<Jurusan> CREATOR = new Creator<Jurusan>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Jurusan createFromParcel(Parcel in) {
            return new Jurusan(in);
        }

        public Jurusan[] newArray(int size) {
            return (new Jurusan[size]);
        }

    }
            ;
    private final static long serialVersionUID = -3365445967953382107L;

    protected Jurusan(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.fkJenis = ((String) in.readValue((String.class.getClassLoader())));
        this.jenisSekolahAsal = ((String) in.readValue((String.class.getClassLoader())));
        this.bidangJurusanAsal = ((String) in.readValue((String.class.getClassLoader())));
        this.namaJurusanAsal = ((String) in.readValue((String.class.getClassLoader())));
        this.ditampilkan = ((String) in.readValue((String.class.getClassLoader())));
        this.keterangan = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Jurusan(String id, String namaJurusanAsal) {
        this.id=id;
        this.namaJurusanAsal=namaJurusanAsal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkJenis() {
        return fkJenis;
    }

    public void setFkJenis(String fkJenis) {
        this.fkJenis = fkJenis;
    }

    public String getJenisSekolahAsal() {
        return jenisSekolahAsal;
    }

    public void setJenisSekolahAsal(String jenisSekolahAsal) {
        this.jenisSekolahAsal = jenisSekolahAsal;
    }

    public String getBidangJurusanAsal() {
        return bidangJurusanAsal;
    }

    public void setBidangJurusanAsal(String bidangJurusanAsal) {
        this.bidangJurusanAsal = bidangJurusanAsal;
    }

    public String getNamaJurusanAsal() {
        return namaJurusanAsal;
    }

    public void setNamaJurusanAsal(String namaJurusanAsal) {
        this.namaJurusanAsal = namaJurusanAsal;
    }

    public String getDitampilkan() {
        return ditampilkan;
    }

    public void setDitampilkan(String ditampilkan) {
        this.ditampilkan = ditampilkan;
    }

    public Object getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(Object keterangan) {
        this.keterangan = keterangan;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(fkJenis);
        dest.writeValue(jenisSekolahAsal);
        dest.writeValue(bidangJurusanAsal);
        dest.writeValue(namaJurusanAsal);
        dest.writeValue(ditampilkan);
        dest.writeValue(keterangan);
    }

    public int describeContents() {
        return 0;
    }

}