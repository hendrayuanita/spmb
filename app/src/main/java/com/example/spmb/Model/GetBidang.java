package com.example.spmb.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetBidang implements Serializable, Parcelable
{

    @SerializedName("pk_field")
    @Expose
    private String pkField;
    @SerializedName("total_rows")
    @Expose
    private String totalRows;
    @SerializedName("arr_data")
    @Expose
    private List<Bidang> arrData = null;
    public final static Creator<GetBidang> CREATOR = new Creator<GetBidang>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetBidang createFromParcel(Parcel in) {
            return new GetBidang(in);
        }

        public GetBidang[] newArray(int size) {
            return (new GetBidang[size]);
        }

    }
            ;
    private final static long serialVersionUID = 3163861040867172955L;

    protected GetBidang(Parcel in) {
        this.pkField = ((String) in.readValue((String.class.getClassLoader())));
        this.totalRows = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.arrData, (com.example.spmb.Model.Bidang.class.getClassLoader()));
    }

    public GetBidang() {
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

    public List<Bidang> getArrData() {
        return arrData;
    }

    public void setArrData(List<Bidang> arrData) {
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