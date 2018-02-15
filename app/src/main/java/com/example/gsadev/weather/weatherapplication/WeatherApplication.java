package com.example.gsadev.weather.weatherapplication;

import android.app.Application;

import com.example.gsadev.weather.dependencyinjection.component.ApplicationComponent;
import com.example.gsadev.weather.dependencyinjection.component.DaggerApplicationComponent;
import com.example.gsadev.weather.dependencyinjection.module.ApplicationModule;


/**
 * Created by GSA Dev on 2/13/2018.
 */

public class WeatherApplication extends Application {
    String BASE_URL="https://query.yahooapis.com";
    ApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        initializedDaggersComponent();
    }

    protected void initializedDaggersComponent() {
       applicationComponent= DaggerApplicationComponent.builder()
               .applicationModule(new ApplicationModule(BASE_URL,getApplicationContext()))
               .build();
    }
    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
