package com.example.spmb.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetSekJenis implements Serializable, Parcelable
{

    @SerializedName("pk_field")
    @Expose
    private String pkField;
    @SerializedName("total_rows")
    @Expose
    private String totalRows;
    @SerializedName("arr_data")
    @Expose
    private List<SekJenis> arrData = null;
    public final static Creator<GetSekJenis> CREATOR = new Creator<GetSekJenis>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetSekJenis createFromParcel(Parcel in) {
            return new GetSekJenis(in);
        }

        public GetSekJenis[] newArray(int size) {
            return (new GetSekJenis[size]);
        }

    }
            ;
    private final static long serialVersionUID = 2097765125548424965L;

    protected GetSekJenis(Parcel in) {
        this.pkField = ((String) in.readValue((String.class.getClassLoader())));
        this.totalRows = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.arrData, (com.example.spmb.Model.SekJenis.class.getClassLoader()));
    }

    public GetSekJenis() {
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

    public List<SekJenis> getArrData() {
        return arrData;
    }

    public void setArrData(List<SekJenis> arrData) {
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
