package com.example.spmb.Model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Jalur implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("fk_jalur")
    @Expose
    private String fkJalur;
    @SerializedName("fk_periode")
    @Expose
    private String fkPeriode;
    @SerializedName("kodeJalur")
    @Expose
    private String kodeJalur;
    @SerializedName("kodeSiakad")
    @Expose
    private String kodeSiakad;
    @SerializedName("namaJalur")
    @Expose
    private String namaJalur;
    @SerializedName("singkatan")
    @Expose
    private String singkatan;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("ujianMasuk")
    @Expose
    private String ujianMasuk;
    @SerializedName("lintasPT")
    @Expose
    private String lintasPT;
    @SerializedName("aktif")
    @Expose
    private String aktif;
    @SerializedName("jenjang")
    @Expose
    private String jenjang;
    @SerializedName("tahunAkademik")
    @Expose
    private String tahunAkademik;
    @SerializedName("target")
    @Expose
    private String target;
    @SerializedName("kodeToken")
    @Expose
    private String kodeToken;
    @SerializedName("kodeTahunPT")
    @Expose
    private String kodeTahunPT;
    @SerializedName("mulaiPendaftaran")
    @Expose
    private String mulaiPendaftaran;
    @SerializedName("akhirPendaftaran")
    @Expose
    private String akhirPendaftaran;
    @SerializedName("biayaDaftar")
    @Expose
    private String biayaDaftar;
    @SerializedName("akhirBayarDaftar")
    @Expose
    private String akhirBayarDaftar;
    @SerializedName("lapKeuangan")
    @Expose
    private String lapKeuangan;
    @SerializedName("kunciSeting")
    @Expose
    private String kunciSeting;
    @SerializedName("webPendaftaran")
    @Expose
    private Object webPendaftaran;
    @SerializedName("kartuRekayasa")
    @Expose
    private String kartuRekayasa;
    @SerializedName("kartuTataNiaga")
    @Expose
    private String kartuTataNiaga;
    @SerializedName("mulaiVerifikasi")
    @Expose
    private Object mulaiVerifikasi;
    @SerializedName("akhirVerifikasi")
    @Expose
    private Object akhirVerifikasi;
    @SerializedName("mulaiLoginDaul")
    @Expose
    private String mulaiLoginDaul;
    @SerializedName("akhirLoginDaul")
    @Expose
    private String akhirLoginDaul;
    @SerializedName("akhirBayarDaul")
    @Expose
    private String akhirBayarDaul;
    public final static Parcelable.Creator<Jalur> CREATOR = new Creator<Jalur>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Jalur createFromParcel(Parcel in) {
            return new Jalur(in);
        }

        public Jalur[] newArray(int size) {
            return (new Jalur[size]);
        }

    }
            ;
    private final static long serialVersionUID = -4523976569564158450L;

    protected Jalur(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.fkJalur = ((String) in.readValue((String.class.getClassLoader())));
        this.fkPeriode = ((String) in.readValue((String.class.getClassLoader())));
        this.kodeJalur = ((String) in.readValue((String.class.getClassLoader())));
        this.kodeSiakad = ((String) in.readValue((String.class.getClassLoader())));
        this.namaJalur = ((String) in.readValue((String.class.getClassLoader())));
        this.singkatan = ((String) in.readValue((String.class.getClassLoader())));
        this.website = ((String) in.readValue((String.class.getClassLoader())));
        this.ujianMasuk = ((String) in.readValue((String.class.getClassLoader())));
        this.lintasPT = ((String) in.readValue((String.class.getClassLoader())));
        this.aktif = ((String) in.readValue((String.class.getClassLoader())));
        this.jenjang = ((String) in.readValue((String.class.getClassLoader())));
        this.tahunAkademik = ((String) in.readValue((String.class.getClassLoader())));
        this.target = ((String) in.readValue((String.class.getClassLoader())));
        this.kodeToken = ((String) in.readValue((String.class.getClassLoader())));
        this.kodeTahunPT = ((String) in.readValue((String.class.getClassLoader())));
        this.mulaiPendaftaran = ((String) in.readValue((String.class.getClassLoader())));
        this.akhirPendaftaran = ((String) in.readValue((String.class.getClassLoader())));
        this.biayaDaftar = ((String) in.readValue((String.class.getClassLoader())));
        this.akhirBayarDaftar = ((String) in.readValue((String.class.getClassLoader())));
        this.lapKeuangan = ((String) in.readValue((String.class.getClassLoader())));
        this.kunciSeting = ((String) in.readValue((String.class.getClassLoader())));
        this.webPendaftaran = ((Object) in.readValue((Object.class.getClassLoader())));
        this.kartuRekayasa = ((String) in.readValue((String.class.getClassLoader())));
        this.kartuTataNiaga = ((String) in.readValue((String.class.getClassLoader())));
        this.mulaiVerifikasi = ((Object) in.readValue((Object.class.getClassLoader())));
        this.akhirVerifikasi = ((Object) in.readValue((Object.class.getClassLoader())));
        this.mulaiLoginDaul = ((String) in.readValue((String.class.getClassLoader())));
        this.akhirLoginDaul = ((String) in.readValue((String.class.getClassLoader())));
        this.akhirBayarDaul = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Jalur() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkJalur() {
        return fkJalur;
    }

    public void setFkJalur(String fkJalur) {
        this.fkJalur = fkJalur;
    }

    public String getFkPeriode() {
        return fkPeriode;
    }

    public void setFkPeriode(String fkPeriode) {
        this.fkPeriode = fkPeriode;
    }

    public String getKodeJalur() {
        return kodeJalur;
    }

    public void setKodeJalur(String kodeJalur) {
        this.kodeJalur = kodeJalur;
    }

    public String getKodeSiakad() {
        return kodeSiakad;
    }

    public void setKodeSiakad(String kodeSiakad) {
        this.kodeSiakad = kodeSiakad;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUjianMasuk() {
        return ujianMasuk;
    }

    public void setUjianMasuk(String ujianMasuk) {
        this.ujianMasuk = ujianMasuk;
    }

    public String getLintasPT() {
        return lintasPT;
    }

    public void setLintasPT(String lintasPT) {
        this.lintasPT = lintasPT;
    }

    public String getAktif() {
        return aktif;
    }

    public void setAktif(String aktif) {
        this.aktif = aktif;
    }

    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
    }

    public String getTahunAkademik() {
        return tahunAkademik;
    }

    public void setTahunAkademik(String tahunAkademik) {
        this.tahunAkademik = tahunAkademik;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getKodeToken() {
        return kodeToken;
    }

    public void setKodeToken(String kodeToken) {
        this.kodeToken = kodeToken;
    }

    public String getKodeTahunPT() {
        return kodeTahunPT;
    }

    public void setKodeTahunPT(String kodeTahunPT) {
        this.kodeTahunPT = kodeTahunPT;
    }

    public String getMulaiPendaftaran() {
        return mulaiPendaftaran;
    }

    public void setMulaiPendaftaran(String mulaiPendaftaran) {
        this.mulaiPendaftaran = mulaiPendaftaran;
    }

    public String getAkhirPendaftaran() {
        return akhirPendaftaran;
    }

    public void setAkhirPendaftaran(String akhirPendaftaran) {
        this.akhirPendaftaran = akhirPendaftaran;
    }

    public String getBiayaDaftar() {
        return biayaDaftar;
    }

    public void setBiayaDaftar(String biayaDaftar) {
        this.biayaDaftar = biayaDaftar;
    }

    public String getAkhirBayarDaftar() {
        return akhirBayarDaftar;
    }

    public void setAkhirBayarDaftar(String akhirBayarDaftar) {
        this.akhirBayarDaftar = akhirBayarDaftar;
    }

    public String getLapKeuangan() {
        return lapKeuangan;
    }

    public void setLapKeuangan(String lapKeuangan) {
        this.lapKeuangan = lapKeuangan;
    }

    public String getKunciSeting() {
        return kunciSeting;
    }

    public void setKunciSeting(String kunciSeting) {
        this.kunciSeting = kunciSeting;
    }

    public Object getWebPendaftaran() {
        return webPendaftaran;
    }

    public void setWebPendaftaran(Object webPendaftaran) {
        this.webPendaftaran = webPendaftaran;
    }

    public String getKartuRekayasa() {
        return kartuRekayasa;
    }

    public void setKartuRekayasa(String kartuRekayasa) {
        this.kartuRekayasa = kartuRekayasa;
    }

    public String getKartuTataNiaga() {
        return kartuTataNiaga;
    }

    public void setKartuTataNiaga(String kartuTataNiaga) {
        this.kartuTataNiaga = kartuTataNiaga;
    }

    public Object getMulaiVerifikasi() {
        return mulaiVerifikasi;
    }

    public void setMulaiVerifikasi(Object mulaiVerifikasi) {
        this.mulaiVerifikasi = mulaiVerifikasi;
    }

    public Object getAkhirVerifikasi() {
        return akhirVerifikasi;
    }

    public void setAkhirVerifikasi(Object akhirVerifikasi) {
        this.akhirVerifikasi = akhirVerifikasi;
    }

    public String getMulaiLoginDaul() {
        return mulaiLoginDaul;
    }

    public void setMulaiLoginDaul(String mulaiLoginDaul) {
        this.mulaiLoginDaul = mulaiLoginDaul;
    }

    public String getAkhirLoginDaul() {
        return akhirLoginDaul;
    }

    public void setAkhirLoginDaul(String akhirLoginDaul) {
        this.akhirLoginDaul = akhirLoginDaul;
    }

    public String getAkhirBayarDaul() {
        return akhirBayarDaul;
    }

    public void setAkhirBayarDaul(String akhirBayarDaul) {
        this.akhirBayarDaul = akhirBayarDaul;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(fkJalur);
        dest.writeValue(fkPeriode);
        dest.writeValue(kodeJalur);
        dest.writeValue(kodeSiakad);
        dest.writeValue(namaJalur);
        dest.writeValue(singkatan);
        dest.writeValue(website);
        dest.writeValue(ujianMasuk);
        dest.writeValue(lintasPT);
        dest.writeValue(aktif);
        dest.writeValue(jenjang);
        dest.writeValue(tahunAkademik);
        dest.writeValue(target);
        dest.writeValue(kodeToken);
        dest.writeValue(kodeTahunPT);
        dest.writeValue(mulaiPendaftaran);
        dest.writeValue(akhirPendaftaran);
        dest.writeValue(biayaDaftar);
        dest.writeValue(akhirBayarDaftar);
        dest.writeValue(lapKeuangan);
        dest.writeValue(kunciSeting);
        dest.writeValue(webPendaftaran);
        dest.writeValue(kartuRekayasa);
        dest.writeValue(kartuTataNiaga);
        dest.writeValue(mulaiVerifikasi);
        dest.writeValue(akhirVerifikasi);
        dest.writeValue(mulaiLoginDaul);
        dest.writeValue(akhirLoginDaul);
        dest.writeValue(akhirBayarDaul);
    }

    public int describeContents() {
        return 0;
    }

}