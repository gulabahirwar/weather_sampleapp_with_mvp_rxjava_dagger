package com.example.gsadev.weather.mapper;

import com.example.gsadev.weather.mvp.model.Forecast;
import com.example.gsadev.weather.mvp.model.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by GSA Dev on 2/15/2018.
 */

public class WeatherMapper {

    @Inject
    public WeatherMapper(){

    }

    public List<Forecast> getListForecast(WeatherResponse response){
        List<Forecast> forecastList=new ArrayList<>();
        if (forecastList==null){
            forecastList=response.getQuery().getResults().getChannel().getItem().getForecast();
        }
        return forecastList;
    }
}
