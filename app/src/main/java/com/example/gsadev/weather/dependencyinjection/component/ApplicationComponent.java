package com.example.gsadev.weather.dependencyinjection.component;

import android.content.Context;

import com.example.gsadev.weather.dependencyinjection.module.ApplicationModule;

import javax.inject.Singleton;
import dagger.Component;
import retrofit2.Retrofit;


/**
 * Created by GSA Dev on 2/14/2018.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Retrofit exposeRetrofit();

    Context exposeContext();
}
