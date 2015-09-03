package com.detroitlabs.codingchallenge.services;

import retrofit.Callback;
import retrofit.http.GET;

import com.detroitlabs.codingchallenge.models.TenDayForecast;


import retrofit.http.Path;

/**
 * Created by anniedevine on 8/24/15.
 */
public interface WundergroundService {

    @GET("/forecast10day/q/{state}/{city}.json")
    void getTenDayForecast(@Path("state") String state,
                                 @Path("city") String city,
                                 Callback<TenDayForecast> forecastCallback);

}
