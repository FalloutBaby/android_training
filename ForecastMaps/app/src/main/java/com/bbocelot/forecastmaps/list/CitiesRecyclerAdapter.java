package com.bbocelot.forecastmaps.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bbocelot.forecastmaps.R;
import com.bbocelot.forecastmaps.model.City;
import com.bbocelot.forecastmaps.model.LargeRussianCities;

import java.util.List;

/**
 * Адаптер для списка городов. Использует статичные данные из LargeRussianCities.
 */
public class CitiesRecyclerAdapter extends RecyclerView.Adapter<CitiesRecyclerAdapter.CityViewHolder> implements View.OnClickListener {
    private final LayoutInflater layoutInflater;
    private CitySelectedListener citySelectedListener;

    public CitiesRecyclerAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public void setCitySelectedListener(CitySelectedListener listener) {
        citySelectedListener = listener;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_city, parent, false);
        view.setOnClickListener(this);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        City city = LargeRussianCities.getCity(position);
        holder.cityNameView.setText(city.name);
        holder.itemView.setTag(R.id.tag_city, city);
    }

    @Override
    public int getItemCount() {
        return LargeRussianCities.getCount();
    }

    @Override
    public void onClick(View v) {
        City city = (City) v.getTag(R.id.tag_city);
        if (citySelectedListener != null && city != null) {
            citySelectedListener.onCitySelected(city);
        }
    }

    static class CityViewHolder extends RecyclerView.ViewHolder {
        final TextView cityNameView;

        public CityViewHolder(View itemView) {
            super(itemView);
            cityNameView = (TextView) itemView.findViewById(R.id.city_name);
        }
    }
}
