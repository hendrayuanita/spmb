package com.example.spmb.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetProvinsi implements Serializable, Parcelable
{

    @SerializedName("pk_field")
    @Expose
    private String pkField;

    @SerializedName("total_rows")
    @Expose
    private String totalRows;
    @SerializedName("arr_data")
    @Expose
    private List<Provinsi> arrData = null;
    @SerializedName("displayComboField")
    @Expose
    private List<String> displayComboField = null;
    @SerializedName("arr_thGroup")
    @Expose
    private List<Object> arrThGroup = null;
    public final static Creator<GetProvinsi> CREATOR = new Creator<GetProvinsi>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetProvinsi createFromParcel(Parcel in) {
            return new GetProvinsi(in);
        }

        public GetProvinsi[] newArray(int size) {
            return (new GetProvinsi[size]);
        }

    }
            ;
    private final static long serialVersionUID = -4222073069520167857L;

    protected GetProvinsi(Parcel in) {
        this.pkField = ((String) in.readValue((String.class.getClassLoader())));
        this.totalRows = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.arrData, (com.example.spmb.Model.Provinsi.class.getClassLoader()));
        in.readList(this.displayComboField, (String.class.getClassLoader()));
        in.readList(this.arrThGroup, (Object.class.getClassLoader()));
    }

    public GetProvinsi() {
    }

    public String getPkField() {
        return pkField;
    }

    public void setPkField(String pkField) {
        this.pkField = pkField;
    }

    public GetProvinsi withPkField(String pkField) {
        this.pkField = pkField;
        return this;
    }

    public String getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(String totalRows) {
        this.totalRows = totalRows;
    }

    public GetProvinsi withTotalRows(String totalRows) {
        this.totalRows = totalRows;
        return this;
    }

    public List<Provinsi> getArrData() {
        return arrData;
    }

    public void setArrData(List<Provinsi> arrData) {
        this.arrData = arrData;
    }

    public GetProvinsi withArrData(List<Provinsi> arrData) {
        this.arrData = arrData;
        return this;
    }

    public List<String> getDisplayComboField() {
        return displayComboField;
    }

    public void setDisplayComboField(List<String> displayComboField) {
        this.displayComboField = displayComboField;
    }

    public GetProvinsi withDisplayComboField(List<String> displayComboField) {
        this.displayComboField = displayComboField;
        return this;
    }



    public List<Object> getArrThGroup() {
        return arrThGroup;
    }

    public void setArrThGroup(List<Object> arrThGroup) {
        this.arrThGroup = arrThGroup;
    }

    public GetProvinsi withArrThGroup(List<Object> arrThGroup) {
        this.arrThGroup = arrThGroup;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pkField);
        dest.writeValue(totalRows);
        dest.writeList(arrData);
        dest.writeList(displayComboField);
        dest.writeList(arrThGroup);
    }

    public int describeContents() {
        return 0;
    }

}