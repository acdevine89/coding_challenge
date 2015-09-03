package com.detroitlabs.codingchallenge.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.detroitlabs.codingchallenge.R;
import com.detroitlabs.codingchallenge.activities.LocationEntryActivity;
import com.detroitlabs.codingchallenge.activities.TenDayForecastActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by anniedevine on 9/1/15.
 */
public class LocationEntryFragment extends Fragment {

    private static final String ARG_CITY_ID = "city_id";
    private static final String ARG_STATE_ID = "state_id";

    @Bind(R.id.entry_city)
    EditText entryCity;

    @Bind(R.id.entry_state)
    EditText entryState;

    @Bind(R.id.submit_button)
    Button submitButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        String city = (String) getArguments().getString(ARG_CITY_ID);
//        String state = (String) getArguments().getString(ARG_STATE_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_user_entry, container, false);
        ButterKnife.bind(this, view);

        entryCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String city = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        entryState.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String state = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bothFieldsReady()) {
                    Intent i = new Intent(getActivity(), TenDayForecastActivity.class);
                    i.putExtra(TenDayForecastFragment.EXTRA_CITY, entryCity.getText().toString());
                    i.putExtra(TenDayForecastFragment.EXTRA_STATE, entryState.getText().toString());
                    startActivity(i);
                } else {
                    Toast.makeText(getActivity(), "Please fill out both fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    return view;
    }

    private boolean bothFieldsReady() {
        if (!fieldIsEmpty(entryCity) && !fieldIsEmpty(entryState)) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean fieldIsEmpty(EditText editText) {
        return editText.getText().toString().isEmpty();
    }

    public static LocationEntryFragment newInstance(String city, String state) {
        Bundle args = new Bundle();
        args.putString(ARG_CITY_ID, city);
        args.putString(ARG_STATE_ID, state);

        LocationEntryFragment fragment = new LocationEntryFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
