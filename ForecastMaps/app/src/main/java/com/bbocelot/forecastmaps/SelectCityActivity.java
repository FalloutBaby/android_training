package com.bbocelot.forecastmaps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.bbocelot.forecastmaps.list.CitiesRecyclerAdapter;
import com.bbocelot.forecastmaps.list.CitySelectedListener;
import com.bbocelot.forecastmaps.list.RecyclerDividersDecoratior;
import com.bbocelot.forecastmaps.model.City;

public class SelectCityActivity extends AppCompatActivity implements CitySelectedListener {

    private static final String TAG = "SelectCity";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerDividersDecoratior(Color.DKGRAY));
        CitiesRecyclerAdapter adapter = new CitiesRecyclerAdapter(this);
        adapter.setCitySelectedListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onCitySelected(City city) {
        Log.i(TAG, "onCitySelected: "+ city);
        // Запускаем экран CityCamActivity, который покажет веб-камеру из выбранного города
        Intent cityCam = new Intent(this, CityCamActivity.class);
        cityCam.putExtra(CityCamActivity.EXTRA_CITY, city);
        startActivity(cityCam);
    }
}