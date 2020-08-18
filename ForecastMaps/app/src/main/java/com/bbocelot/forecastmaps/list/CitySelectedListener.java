package com.bbocelot.forecastmaps.list;

import com.bbocelot.forecastmaps.model.City;

/**
 * Интерфейс для получения событий от списка городов.
 */
public interface CitySelectedListener {
    /**
     * Вызывается, когда указанный город был выбран в списке городов.
     */
    void onCitySelected(City city);
}
