package com.detroitlabs.codingchallenge.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.detroitlabs.codingchallenge.R;
import com.detroitlabs.codingchallenge.models.Forecast;
import com.detroitlabs.codingchallenge.models.ForecastDay;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by anniedevine on 8/25/15.
 */
public class ListAdapter extends ArrayAdapter<ForecastDay> {
    private List<ForecastDay> forecastList;

    public ListAdapter(Context context, int resource, List<ForecastDay> forecastList) {
        super(context, resource, forecastList);
        this.forecastList = forecastList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        String fullDate = forecastList.get(position).getDate().getWeekday_short()
        + " " + forecastList.get(position).getDate().getMonthname_short()
        + " " + forecastList.get(position).getDate().getDay();

        String iconName = forecastList.get(position).getIcon();
        String iconURL = "http://icons.wxug.com/i/c/i/" + iconName + ".gif";

        new DownloadIconTask(holder.icon).execute(iconURL);

        holder.date.setText(fullDate);
        holder.conditions.setText(forecastList.get(position).getConditions());
        holder.high.setText(Integer.toString(forecastList.get(position).getHigh().getFahrenheit()));
        holder.low.setText(Integer.toString(forecastList.get(position).getLow().getFahrenheit()));

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.weather_icon)
        ImageView icon;

        @Bind(R.id.date)
        TextView date;

        @Bind(R.id.conditions)
        TextView conditions;

        @Bind(R.id.high_value)
        TextView high;

        @Bind(R.id.low_value)
        TextView low;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private class DownloadIconTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bitmapImage;

        public DownloadIconTask(ImageView bitmapImage) {
            this.bitmapImage = bitmapImage;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String urlDisplay = urls[0];
            Bitmap weatherIcon = null;
            try {
                InputStream in = new java.net.URL(urlDisplay).openStream();
                weatherIcon = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return weatherIcon;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            bitmapImage.setImageBitmap(bitmap);
        }
    }
}
