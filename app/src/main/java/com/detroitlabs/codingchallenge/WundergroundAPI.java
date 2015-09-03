package com.detroitlabs.codingchallenge;

import android.util.Log;

import com.detroitlabs.codingchallenge.models.TenDayForecast;
import com.detroitlabs.codingchallenge.services.WundergroundService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by anniedevine on 8/24/15.
 */
public class WundergroundAPI {
    private final String TAG = getClass().getSimpleName();
    private RestAdapter restAdapter;
    private WundergroundService wundergroundService;
    private static final String BASE_URL = BuildConfig.ROOT_URL + BuildConfig.API_KEY;
    private static WundergroundAPI wundergroundAPI;

    public static WundergroundAPI getWundergroundAPI() {
        if (wundergroundAPI == null) {
            wundergroundAPI = new WundergroundAPI();
        }
        return wundergroundAPI;
    }

    public WundergroundAPI() {
        restAdapter = new RestAdapter.Builder()
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setEndpoint(BASE_URL)
            .build();
        WundergroundService wundergroundService = restAdapter.create(WundergroundService.class);
        Log.d(TAG, "WundergroundAPI created");
    }

    public void getTenDayForecast(String state, String city, Callback<TenDayForecast> forecastCallback) {
        wundergroundService.getTenDayForecast(state, city, forecastCallback);
    }
}