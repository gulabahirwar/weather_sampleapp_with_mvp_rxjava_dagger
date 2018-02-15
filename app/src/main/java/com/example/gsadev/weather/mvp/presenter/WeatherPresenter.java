package com.example.gsadev.weather.mvp.presenter;

import com.example.gsadev.weather.api.WeatherApiService;
import com.example.gsadev.weather.base.BasePresenter;
import com.example.gsadev.weather.mapper.WeatherMapper;
import com.example.gsadev.weather.mvp.model.Astronomy;
import com.example.gsadev.weather.mvp.model.Forecast;
import com.example.gsadev.weather.mvp.model.Location;
import com.example.gsadev.weather.mvp.model.WeatherResponse;
import com.example.gsadev.weather.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

/**
 * Created by GSA Dev on 2/14/2018.
 */

public class WeatherPresenter extends BasePresenter<MainView>{
    @Inject
    WeatherApiService weatherApiService;
    @Inject
    WeatherMapper weatherMapper;

   @Inject
   public WeatherPresenter(){
    }

    public void getWeatherData() {
        getView().onLoading("Loading...");
        Observable<WeatherResponse> observable = weatherApiService.getWeatherResponse();
        subscribe(observable, new Observer<WeatherResponse>() {
            @Override
            public void onCompleted() {
                getView().onHideDialog();
                getView().onLoadingComplete("Loading completed");
            }

            @Override
            public void onError(Throwable e) {
                getView().onHideDialog();
                getView().onLoadingError("Something went wrong");
            }

            @Override
            public void onNext(WeatherResponse weatherResponse) {
             List<Forecast> forecasts=weatherResponse.getQuery().getResults().getChannel().getItem().getForecast();
             Astronomy astronomy=weatherResponse.getQuery().getResults().getChannel().getAstronomy();
             Location location=weatherResponse.getQuery().getResults().getChannel().getLocation();
             getView().getLoadForecast(forecasts,astronomy,location);
            }
        });

    }
}
