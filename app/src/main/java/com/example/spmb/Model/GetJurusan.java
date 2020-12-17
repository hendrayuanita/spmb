package com.example.spmb.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetJurusan implements Serializable, Parcelable
{

    @SerializedName("pk_field")
    @Expose
    private String pkField;
    @SerializedName("total_rows")
    @Expose
    private String totalRows;
    @SerializedName("arr_data")
    @Expose
    private List<Jurusan> arrData = null;
    public final static Creator<GetJurusan> CREATOR = new Creator<GetJurusan>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetJurusan createFromParcel(Parcel in) {
            return new GetJurusan(in);
        }

        public GetJurusan[] newArray(int size) {
            return (new GetJurusan[size]);
        }

    }
            ;
    private final static long serialVersionUID = 4165627710393905236L;

    protected GetJurusan(Parcel in) {
        this.pkField = ((String) in.readValue((String.class.getClassLoader())));
        this.totalRows = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.arrData, (com.example.spmb.Model.Jurusan.class.getClassLoader()));
    }

    public GetJurusan() {
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

    public List<Jurusan> getArrData() {
        return arrData;
    }

    public void setArrData(List<Jurusan> arrData) {
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