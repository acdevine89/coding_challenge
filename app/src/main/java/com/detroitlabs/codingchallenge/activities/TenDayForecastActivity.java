package com.detroitlabs.codingchallenge.activities;

import android.support.v4.app.Fragment;

import com.detroitlabs.codingchallenge.fragments.TenDayForecastFragment;

/**
 * Created by anniedevine on 9/2/15.
 */
public class TenDayForecastActivity extends SingleFragmentActivity {

    public String hello;

    @Override
    protected Fragment createFragment() {
        String city = (String) getIntent().getStringExtra(TenDayForecastFragment.EXTRA_CITY);
        String state = (String) getIntent().getStringExtra(TenDayForecastFragment.EXTRA_STATE);
        return TenDayForecastFragment.newInstance(city, state);
    }


}
