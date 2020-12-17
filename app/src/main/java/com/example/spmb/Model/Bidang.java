package com.example.spmb.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Bidang implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("kode")
    @Expose
    private String kode;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("namaBidang")
    @Expose
    private String namaBidang;
    public final static Creator<Bidang> CREATOR = new Creator<Bidang>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Bidang createFromParcel(Parcel in) {
            return new Bidang(in);
        }

        public Bidang[] newArray(int size) {
            return (new Bidang[size]);
        }

    }
            ;
    private final static long serialVersionUID = 6406213682839244193L;

    protected Bidang(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.kode = ((String) in.readValue((String.class.getClassLoader())));
        this.mode = ((String) in.readValue((String.class.getClassLoader())));
        this.namaBidang = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Bidang(String id, String namaBidang) {
        this.id=id;
        this.namaBidang=namaBidang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getNamaBidang() {
        return namaBidang;
    }

    public void setNamaBidang(String namaBidang) {
        this.namaBidang = namaBidang;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(kode);
        dest.writeValue(mode);
        dest.writeValue(namaBidang);
    }

    public int describeContents() {
        return 0;
    }

}