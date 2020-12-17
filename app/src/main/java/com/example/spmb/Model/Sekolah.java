package com.example.spmb.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sekolah implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("fk_kabupaten")
    @Expose
    private String fkKabupaten;
    @SerializedName("fk_jenis")
    @Expose
    private String fkJenis;
    @SerializedName("npsn")
    @Expose
    private Object npsn;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("namaDikti")
    @Expose
    private Object namaDikti;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("telp")
    @Expose
    private Object telp;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("valid")
    @Expose
    private String valid;
    public final static Creator<Sekolah> CREATOR = new Creator<Sekolah>() {



        @SuppressWarnings({
                "unchecked"
        })
        public Sekolah createFromParcel(Parcel in) {
            return new Sekolah(in);
        }

        public Sekolah[] newArray(int size) {
            return (new Sekolah[size]);
        }

    }
            ;
    private final static long serialVersionUID = 3384016134796007000L;

    protected Sekolah(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.fkKabupaten = ((String) in.readValue((String.class.getClassLoader())));
        this.fkJenis = ((String) in.readValue((String.class.getClassLoader())));
        this.npsn = ((Object) in.readValue((Object.class.getClassLoader())));
        this.nama = ((String) in.readValue((String.class.getClassLoader())));
        this.namaDikti = ((Object) in.readValue((Object.class.getClassLoader())));
        this.alamat = ((String) in.readValue((String.class.getClassLoader())));
        this.telp = ((Object) in.readValue((Object.class.getClassLoader())));
        this.keterangan = ((String) in.readValue((String.class.getClassLoader())));
        this.valid = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Sekolah(String id, String nama) {
        this.id = id;
        this.nama=nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkKabupaten() {
        return fkKabupaten;
    }

    public void setFkKabupaten(String fkKabupaten) {
        this.fkKabupaten = fkKabupaten;
    }

    public String getFkJenis() {
        return fkJenis;
    }

    public void setFkJenis(String fkJenis) {
        this.fkJenis = fkJenis;
    }

    public Object getNpsn() {
        return npsn;
    }

    public void setNpsn(Object npsn) {
        this.npsn = npsn;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Object getNamaDikti() {
        return namaDikti;
    }

    public void setNamaDikti(Object namaDikti) {
        this.namaDikti = namaDikti;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Object getTelp() {
        return telp;
    }

    public void setTelp(Object telp) {
        this.telp = telp;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(fkKabupaten);
        dest.writeValue(fkJenis);
        dest.writeValue(npsn);
        dest.writeValue(nama);
        dest.writeValue(namaDikti);
        dest.writeValue(alamat);
        dest.writeValue(telp);
        dest.writeValue(keterangan);
        dest.writeValue(valid);
    }

    public int describeContents() {
        return 0;
    }

}