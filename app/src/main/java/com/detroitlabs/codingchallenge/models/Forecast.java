package com.detroitlabs.codingchallenge.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anniedevine on 8/24/15.
 */
public class Forecast {
    @SerializedName("simpleforecast")
    private SimpleForecast simpleforecast;

    public Forecast() {

    }

    public ForecastDay[] getForecastDays() {
        return simpleforecast.getForecastDay();
    }

    //    public ForecastDay[] getForecastDay() {
//        return forecastday;
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeParcelableArray(this.forecastday, 0);
//    }
//
//    protected Forecast(Parcel in) {
//        this.forecastday = (ForecastDay[])
//                in.readParcelableArray(ForecastDay.class.getClassLoader());
//    }
//
//    public static final Creator<Forecast> CREATOR = new Creator<Forecast>() {
//        public Forecast createFromParcel(Parcel source) {
//            return new Forecast(source);
//        }
//
//        public Forecast[] newArray(int size) {
//            return new Forecast[size];
//        }
//    };

}
