package com.example.weather.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weather.R;
import com.example.weather.model.Weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HourAdapter extends RecyclerView.Adapter {

    private Activity activity;

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
        this.notifyDataSetChanged();
    }

    private List<Weather> weathers;

    public HourAdapter(Activity activity, List<Weather> weathers) {
        this.activity = activity;
        this.weathers = weathers;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.item_hour, parent, false);
        HourHolder holder = new HourHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HourHolder vh = (HourHolder) holder;
        Weather weather = weathers.get(position);
        vh.tvTime.setText(convertTime(weather.getDateTime()));
        vh.tvTem.setText(weather.getTemperature().getValue()+"");
        String url = "";

        if (weather.getWeatherIcon() < 10) {
            url = "http://developer.accuweather.com/sites/default/files/0" + weather.getWeatherIcon() + "-s.png";
        } else {
            url = "http://developer.accuweather.com/sites/default/files/" + weather.getWeatherIcon() + "-s.png";
        }

        Glide.with(activity).load(url).into(vh.icon);

    }

    @Override
    public int getItemCount() {
        return weathers.size();
    }

    public static class HourHolder extends RecyclerView.ViewHolder {
        private TextView tvTime;
        private TextView tvTem;
        private ImageView icon;

        public HourHolder(View itemView) {
            super(itemView);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            tvTem = (TextView) itemView.findViewById(R.id.tvTime);
            icon = (ImageView) itemView.findViewById(R.id.icon);
        }
    }
    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }

}
