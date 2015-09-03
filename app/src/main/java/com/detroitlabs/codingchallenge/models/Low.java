package com.detroitlabs.codingchallenge.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by anniedevine on 8/24/15.
 */
public class Low implements Parcelable {
    private int fahrenheit;
    private int celsius;

    public Low() {

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

    protected Low(Parcel in) {
        this.fahrenheit = in.readInt();
        this.celsius = in.readInt();
    }

    public static final Creator<Low> CREATOR = new Creator<Low>() {
        @Override
        public Low createFromParcel(Parcel source) {
            return new Low(source);
        }

        @Override
        public Low[] newArray(int size) {
            return new Low[size];
        }
    };
}
