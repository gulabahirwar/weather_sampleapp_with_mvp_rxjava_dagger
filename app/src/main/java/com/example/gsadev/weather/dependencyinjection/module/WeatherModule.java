package com.example.gsadev.weather.dependencyinjection.module;

import com.example.gsadev.weather.api.WeatherApiService;
import com.example.gsadev.weather.dependencyinjection.scopes.PerActivity;
import com.example.gsadev.weather.mvp.view.MainView;
import com.example.gsadev.weather.weatherapplication.WeatherApplication;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by GSA Dev on 2/14/2018.
 */
@Module
public class WeatherModule {
    MainView view;

    public WeatherModule(MainView view){
        this.view=view;
    }
    @PerActivity
    @Provides
    MainView getMainView(){
        return view;
    }

    @PerActivity
    @Provides
    WeatherApiService provideApplication(Retrofit retrofit){
        return retrofit.create(WeatherApiService.class);
    }
}
