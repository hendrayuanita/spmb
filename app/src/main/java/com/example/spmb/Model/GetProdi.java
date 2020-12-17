package com.example.spmb.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetProdi implements Serializable, Parcelable
{

    @SerializedName("pk_field")
    @Expose
    private String pkField;
    @SerializedName("total_rows")
    @Expose
    private String totalRows;
    @SerializedName("arr_data")
    @Expose
    private List<Prodi> arrData = null;
    public final static Creator<GetProdi> CREATOR = new Creator<GetProdi>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetProdi createFromParcel(Parcel in) {
            return new GetProdi(in);
        }

        public GetProdi[] newArray(int size) {
            return (new GetProdi[size]);
        }

    }
            ;
    private final static long serialVersionUID = 3531706713370365739L;

    protected GetProdi(Parcel in) {
        this.pkField = ((String) in.readValue((String.class.getClassLoader())));
        this.totalRows = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.arrData, (com.example.spmb.Model.Prodi.class.getClassLoader()));
    }

    public GetProdi() {
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

    public List<Prodi> getArrData() {
        return arrData;
    }

    public void setArrData(List<Prodi> arrData) {
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