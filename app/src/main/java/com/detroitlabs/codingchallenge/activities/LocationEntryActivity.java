package com.detroitlabs.codingchallenge.activities;

import android.support.v4.app.Fragment;

import com.detroitlabs.codingchallenge.fragments.LocationEntryFragment;

/**
 * Created by anniedevine on 9/2/15.
 */
public class LocationEntryActivity extends SingleFragmentActivity {

    private static final String EXTRA_CITY_ID =
            "com.detroitlabs.android.codingchallenge.city_id";

    private static final String EXTRA_STATE_ID =
            "com.detroitlabs.android.codingchallenge.state_id";

    @Override
    protected Fragment createFragment() {
        String cityID = (String) getIntent().getStringExtra(EXTRA_CITY_ID);
        String stateID = (String) getIntent().getStringExtra(EXTRA_STATE_ID);
        return LocationEntryFragment.newInstance(cityID, stateID);
    }
}
