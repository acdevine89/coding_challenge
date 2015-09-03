package com.detroitlabs.codingchallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by anniedevine on 8/24/15.
 */
public class Date implements Parcelable {
    private String weekday_short;
    private String monthname_short;
    private String day;

    public Date() {

    }

    public String getWeekday_short() {
        return weekday_short;
    }

    public void setWeekday_short(String weekday_short) {
        this.weekday_short = weekday_short;
    }

    public String getMonthname_short() {
        return monthname_short;
    }

    public void setMonthname_short(String monthname_short) {
        this.monthname_short = monthname_short;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.weekday_short);
        dest.writeString(this.monthname_short);
        dest.writeString(this.day);
    }

    protected Date(Parcel in) {
        this.weekday_short = in.readString();
        this.monthname_short = in.readString();
        this.day = in.readString();
    }

    public static final Creator<Date> CREATOR = new Creator<Date>() {
        @Override
        public Date createFromParcel(Parcel source) {
            return new Date(source);
        }

        @Override
        public Date[] newArray(int size) {
            return new Date[size];
        }
    };

}
