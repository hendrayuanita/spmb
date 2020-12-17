package com.example.spmb.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetKabupaten implements Serializable, Parcelable
{

    @SerializedName("pk_field")
    @Expose
    private String pkField;
    @SerializedName("total_rows")
    @Expose
    private String totalRows;
    @SerializedName("arr_data")
    @Expose
    private List<Kabupaten> arrData = null;
    public final static Creator<GetKabupaten> CREATOR = new Creator<GetKabupaten>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetKabupaten createFromParcel(Parcel in) {
            return new GetKabupaten(in);
        }

        public GetKabupaten[] newArray(int size) {
            return (new GetKabupaten[size]);
        }

    }
            ;
    private final static long serialVersionUID = -5009877605195641211L;

    protected GetKabupaten(Parcel in) {
        this.pkField = ((String) in.readValue((String.class.getClassLoader())));
        this.totalRows = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.arrData, (com.example.spmb.Model.Kabupaten.class.getClassLoader()));
    }

    public GetKabupaten() {
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

    public List<Kabupaten> getArrData() {
        return arrData;
    }

    public void setArrData(List<Kabupaten> arrData) {
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