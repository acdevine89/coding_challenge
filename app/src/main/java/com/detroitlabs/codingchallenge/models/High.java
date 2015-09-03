package com.detroitlabs.codingchallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by anniedevine on 8/24/15.
 */
public class High implements Parcelable {
    private int fahrenheit;
    private int celsius;

    public High() {

    }

    public int getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(int fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public int getCelsius() {
        return celsius;
    }

    public void setCelsius(int celsius) {
        this.celsius = celsius;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.fahrenheit);
        dest.writeInt(this.celsius);
    }

    protected High(Parcel in) {
        this.fahrenheit = in.readInt();
        this.celsius = in.readInt();
    }

    public static final Creator<High> CREATOR = new Creator<High>() {

        @Override
        public High createFromParcel(Parcel source) {
            return new High(source);
        }

        @Override
        public High[] newArray(int size) {
            return new High[size];
        }
    };
}
