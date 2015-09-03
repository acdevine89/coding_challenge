package com.detroitlabs.codingchallenge.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anniedevine on 8/25/15.
 */
public class SimpleForecast {
    @SerializedName("forecastday")
    private ForecastDay[] forecastday
            ;

    public SimpleForecast() {

    }

    public ForecastDay[] getForecastDay() {
        return forecastday;
    }
}
