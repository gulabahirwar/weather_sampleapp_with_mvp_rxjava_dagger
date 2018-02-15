package com.example.gsadev.weather.mvp.view;

import com.example.gsadev.weather.mvp.model.Astronomy;
import com.example.gsadev.weather.mvp.model.Forecast;
import com.example.gsadev.weather.mvp.model.Location;

import java.util.List;

/**
 * Created by GSA Dev on 2/14/2018.
 */

public interface MainView extends BaseView{
    void getLoadForecast(List<Forecast> forecasts, Astronomy astronomy,Location location);

    void onLoading(String msg);

    void onLoadingComplete(String msg);

    void onLoadingError(String s);

    void onHideDialog();
}
