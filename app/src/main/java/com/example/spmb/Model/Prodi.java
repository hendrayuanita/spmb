package com.example.spmb.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Prodi implements Serializable, Parcelable
{

    @SerializedName("idprodiValid")
    @Expose
    private String idprodiValid;
    @SerializedName("fk_prodi")
    @Expose
    private String fkProdi;
    @SerializedName("fk_jurusanAsal")
    @Expose
    private String fkJurusanAsal;
    @SerializedName("namaJenjang")
    @Expose
    private String namaJenjang;
    @SerializedName("namaProdi")
    @Expose
    private String namaProdi;
    @SerializedName("namaJurusanAsal")
    @Expose
    private String namaJurusanAsal;
    @SerializedName("bidangJurusanAsal")
    @Expose
    private String bidangJurusanAsal;
    public final static Creator<Prodi> CREATOR = new Creator<Prodi>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Prodi createFromParcel(Parcel in) {
            return new Prodi(in);
        }

        public Prodi[] newArray(int size) {
            return (new Prodi[size]);
        }

    }
            ;
    private final static long serialVersionUID = 7352140740060133225L;

    protected Prodi(Parcel in) {
        this.idprodiValid = ((String) in.readValue((String.class.getClassLoader())));
        this.fkProdi = ((String) in.readValue((String.class.getClassLoader())));
        this.fkJurusanAsal = ((String) in.readValue((String.class.getClassLoader())));
        this.namaJenjang = ((String) in.readValue((String.class.getClassLoader())));
        this.namaProdi = ((String) in.readValue((String.class.getClassLoader())));
        this.namaJurusanAsal = ((String) in.readValue((String.class.getClassLoader())));
        this.bidangJurusanAsal = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Prodi(String idprodiValid, String namaProdi) {
        this.idprodiValid = idprodiValid;
        this.namaProdi = namaProdi;
    }

    public String getIdprodiValid() {
        return idprodiValid;
    }

    public void setIdprodiValid(String idprodiValid) {
        this.idprodiValid = idprodiValid;
    }

    public String getFkProdi() {
        return fkProdi;
    }

    public void setFkProdi(String fkProdi) {
        this.fkProdi = fkProdi;
    }

    public String getFkJurusanAsal() {
        return fkJurusanAsal;
    }

    public void setFkJurusanAsal(String fkJurusanAsal) {
        this.fkJurusanAsal = fkJurusanAsal;
    }

    public String getNamaJenjang() {
        return namaJenjang;
    }

    public void setNamaJenjang(String namaJenjang) {
        this.namaJenjang = namaJenjang;
    }

    public String getNamaProdi() {
        return namaProdi;
    }

    public void setNamaProdi(String namaProdi) {
        this.namaProdi = namaProdi;
    }

    public String getNamaJurusanAsal() {
        return namaJurusanAsal;
    }

    public void setNamaJurusanAsal(String namaJurusanAsal) {
        this.namaJurusanAsal = namaJurusanAsal;
    }

    public String getBidangJurusanAsal() {
        return bidangJurusanAsal;
    }

    public void setBidangJurusanAsal(String bidangJurusanAsal) {
        this.bidangJurusanAsal = bidangJurusanAsal;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(idprodiValid);
        dest.writeValue(fkProdi);
        dest.writeValue(fkJurusanAsal);
        dest.writeValue(namaJenjang);
        dest.writeValue(namaProdi);
        dest.writeValue(namaJurusanAsal);
        dest.writeValue(bidangJurusanAsal);
    }

    public int describeContents() {
        return 0;
    }

}