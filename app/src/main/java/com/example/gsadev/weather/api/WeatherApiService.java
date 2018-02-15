package com.example.gsadev.weather.api;

import com.example.gsadev.weather.mvp.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;


/**
 * Created by GSA Dev on 2/13/2018.
 */

public interface WeatherApiService {
    @GET("/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D\"bangalore\")&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
    Observable<WeatherResponse> getWeatherResponse();
}