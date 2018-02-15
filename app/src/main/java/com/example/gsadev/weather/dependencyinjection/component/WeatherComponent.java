package com.example.gsadev.weather.dependencyinjection.component;

import android.content.Context;

import com.example.gsadev.weather.dependencyinjection.module.WeatherModule;
import com.example.gsadev.weather.dependencyinjection.scopes.PerActivity;
import com.example.gsadev.weather.modules.home.MainActivity;

import dagger.Component;

/**
 * Created by GSA Dev on 2/14/2018.
 */
@PerActivity
@Component(modules = WeatherModule.class,dependencies = ApplicationComponent.class)
public interface WeatherComponent {
    void  inject(MainActivity activity);
}
