package com.detroitlabs.codingchallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anniedevine on 8/24/15.
 */
public class ForecastDay implements Parcelable {
    private String icon;
    private String conditions;
    private int period;

    @SerializedName("high")
    private High high;

    @SerializedName("low")
    private Low low;

    @SerializedName("date")
    private Date date;

    public ForecastDay() {

    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

    public Low getLow() {
        return low;
    }

    public void setLow(Low low) {
        this.low = low;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.icon);
        dest.writeString(this.conditions);
        dest.writeInt(this.period);
        dest.writeParcelable(this.high, 0);
        dest.writeParcelable(this.low, 0);
        dest.writeParcelable(this.date, 0);
    }

    protected ForecastDay(Parcel in) {
        this.icon = in.readString();
        this.conditions = in.readString();
        this.period = in.readInt();
        this.high = in.readParcelable(High.class.getClassLoader());
        this.low = in.readParcelable(Low.class.getClassLoader());
        this.date = in.readParcelable(Date.class.getClassLoader());
    }

    public static final Creator<ForecastDay> CREATOR = new Creator<ForecastDay>() {
        @Override
        public ForecastDay createFromParcel(Parcel source) {
            return new ForecastDay(source);
        }

        @Override
        public ForecastDay[] newArray(int size) {
            return new ForecastDay[size];
        }
    };
}
