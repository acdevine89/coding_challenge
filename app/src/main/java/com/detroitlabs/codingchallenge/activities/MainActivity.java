package com.detroitlabs.codingchallenge.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.detroitlabs.codingchallenge.BuildConfig;
import com.detroitlabs.codingchallenge.fragments.LocationEntryFragment;
import com.detroitlabs.codingchallenge.R;
import com.detroitlabs.codingchallenge.adapters.ListAdapter;
import com.detroitlabs.codingchallenge.models.ForecastDay;
import com.detroitlabs.codingchallenge.models.TenDayForecast;
import com.detroitlabs.codingchallenge.services.WundergroundService;

import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

//public class MainActivity extends SingleFragmentActivity {
//    protected final String TAG = getClass().getSimpleName();
//    protected RestAdapter restAdapter;
//    private static final String BASE_URL = BuildConfig.ROOT_URL + BuildConfig.API_KEY;
//    private WundergroundService wundergroundService;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_ten_day_forecast);
//        ButterKnife.bind(this);
//
//        restAdapter = new RestAdapter.Builder()
//                .setLogLevel(RestAdapter.LogLevel.FULL)
//                .setEndpoint(BASE_URL)
//                .build();
//        WundergroundService wundergroundService = restAdapter.create(WundergroundService.class);
//        Log.d(TAG, "WundergroundAPI created");
//
//        wundergroundService.getTenDayForecast("MI", "Detroit", new Callback<TenDayForecast>() {
//            @Override
//            public void success(TenDayForecast tenDayForecast, Response response) {
//                Log.i("response", "success");
//
//                ForecastDay[] forecastArray = tenDayForecast.getForecast().getForecastDays();
//                List<ForecastDay> tenDayForecastList = Arrays.asList(forecastArray);
//
//                ListAdapter forecastAdapter = new ListAdapter(getApplicationContext(), R.layout.list_item, tenDayForecastList);
//                listView.setAdapter(forecastAdapter);
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                Log.i("response", "failure");
//            }
//        });
//    }
//
//    @Override
//    protected Fragment createFragment() {
//        return new LocationEntryFragment();
//    }
//}