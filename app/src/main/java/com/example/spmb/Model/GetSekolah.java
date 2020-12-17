package com.example.spmb.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetSekolah implements Serializable, Parcelable
{

    @SerializedName("pk_field")
    @Expose
    private String pkField;
    @SerializedName("total_rows")
    @Expose
    private String totalRows;
    @SerializedName("arr_data")
    @Expose
    private List<Sekolah> arrData = null;
    public final static Creator<GetSekolah> CREATOR = new Creator<GetSekolah>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetSekolah createFromParcel(Parcel in) {
            return new GetSekolah(in);
        }

        public GetSekolah[] newArray(int size) {
            return (new GetSekolah[size]);
        }

    }
            ;
    private final static long serialVersionUID = -6381040995901961716L;

    protected GetSekolah(Parcel in) {
        this.pkField = ((String) in.readValue((String.class.getClassLoader())));
        this.totalRows = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.arrData, (com.example.spmb.Model.Sekolah.class.getClassLoader()));
    }

    public GetSekolah() {
    }

    public String getPkField() {
        return pkField;
    }

    public void setPkField(String pkField) {
        this.pkField = pkField;
    }

    public String getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(String totalRows) {
        this.totalRows = totalRows;
    }

    public List<Sekolah> getArrData() {
        return arrData;
    }

    public void setArrData(List<Sekolah> arrData) {
        this.arrData = arrData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pkField);
        dest.writeValue(totalRows);
        dest.writeList(arrData);
    }

    public int describeContents() {
        return 0;
    }

}