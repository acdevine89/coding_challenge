package com.detroitlabs.codingchallenge.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ListView;

import com.detroitlabs.codingchallenge.BuildConfig;
import com.detroitlabs.codingchallenge.R;
import com.detroitlabs.codingchallenge.activities.SingleFragmentActivity;
import com.detroitlabs.codingchallenge.adapters.ListAdapter;
import com.detroitlabs.codingchallenge.models.ForecastDay;
import com.detroitlabs.codingchallenge.models.TenDayForecast;
import com.detroitlabs.codingchallenge.services.WundergroundService;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by anniedevine on 9/2/15.
 */
public class TenDayForecastFragment extends Fragment {
    public static final String EXTRA_CITY = "com.detroitlabs.android.codingchallenge.city_id";
    public static final String EXTRA_STATE = "com.detroitlabs.android.codingchallenge.state_id";

    protected final String TAG = getClass().getSimpleName();
    protected RestAdapter restAdapter;

    private static final String BASE_URL = BuildConfig.ROOT_URL + BuildConfig.API_KEY;
    private WundergroundService wundergroundService;

    @Bind(R.id.list_view)
    ListView listView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String city = (String) getArguments().getString(EXTRA_CITY);
        String state = (String) getArguments().getString(EXTRA_STATE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_ten_day_forecast, container, false);
        ButterKnife.bind(this, view);

        restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .build();
        WundergroundService wundergroundService = restAdapter.create(WundergroundService.class);
        Log.d(TAG, "WundergroundAPI created");

        wundergroundService.getTenDayForecast(getArguments().getString(EXTRA_STATE), getArguments().getString(EXTRA_CITY), new Callback<TenDayForecast>() {
            @Override
            public void success(TenDayForecast tenDayForecast, Response response) {
                Log.i("response", "success");

                ForecastDay[] forecastArray = tenDayForecast.getForecast().getForecastDays();
                List<ForecastDay> tenDayForecastList = Arrays.asList(forecastArray);

                ListAdapter forecastAdapter = new ListAdapter(getActivity(), R.layout.list_item, tenDayForecastList);
                listView.setAdapter(forecastAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("response", "failure");
            }
        });

        return view;
    }

    public static TenDayForecastFragment newInstance(String city, String state) {
        Bundle args = new Bundle();
        args.putString(EXTRA_CITY, city);
        args.putString(EXTRA_STATE, state);

        TenDayForecastFragment fragment = new TenDayForecastFragment();
        fragment.setArguments(args);

        return fragment;
    }

}