package com.example.spmb.Model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetJalur implements Serializable, Parcelable
{

    @SerializedName("filename")
    @Expose
    private Boolean filename;
    @SerializedName("file_name")
    @Expose
    private Boolean fileName;
    @SerializedName("pagename")
    @Expose
    private Boolean pagename;
    @SerializedName("page_name")
    @Expose
    private Boolean pageName;
    @SerializedName("pk_field")
    @Expose
    private String pkField;
    @SerializedName("total_rows")
    @Expose
    private String totalRows;
    @SerializedName("arr_data")
    @Expose
    private List<Jalur> arrData = null;
    public final static Parcelable.Creator<GetJalur> CREATOR = new Creator<GetJalur>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetJalur createFromParcel(Parcel in) {
            return new GetJalur(in);
        }

        public GetJalur[] newArray(int size) {
            return (new GetJalur[size]);
        }

    }
            ;
    private final static long serialVersionUID = -8249567326623758424L;

    protected GetJalur(Parcel in) {
        this.filename = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.fileName = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.pagename = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.pageName = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.pkField = ((String) in.readValue((String.class.getClassLoader())));
        this.totalRows = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.arrData, (com.example.spmb.Model.Jalur.class.getClassLoader()));
    }

    public GetJalur() {
    }

    public Boolean getFilename() {
        return filename;
    }

    public void setFilename(Boolean filename) {
        this.filename = filename;
    }

    public Boolean getFileName() {
        return fileName;
    }

    public void setFileName(Boolean fileName) {
        this.fileName = fileName;
    }

    public Boolean getPagename() {
        return pagename;
    }

    public void setPagename(Boolean pagename) {
        this.pagename = pagename;
    }

    public Boolean getPageName() {
        return pageName;
    }

    public void setPageName(Boolean pageName) {
        this.pageName = pageName;
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

    public List<Jalur> getArrData() {
        return arrData;
    }

    public void setArrData(List<Jalur> arrData) {
        this.arrData = arrData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(filename);
        dest.writeValue(fileName);
        dest.writeValue(pagename);
        dest.writeValue(pageName);
        dest.writeValue(pkField);
        dest.writeValue(totalRows);
        dest.writeList(arrData);
    }

    public int describeContents() {
        return 0;
    }

}