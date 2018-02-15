package com.example.gsadev.weather.dependencyinjection.module;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GSA Dev on 2/14/2018.
 */
@Module
public class ApplicationModule {
    String BaseURl;
    Context context;

    public ApplicationModule(String baseURl,Context context){
        this.BaseURl=baseURl;
        this.context=context;
    }
    @Singleton
    @Provides
    GsonConverterFactory gsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    RxJavaCallAdapterFactory rxJavaCallAdapterFactory(){
        return RxJavaCallAdapterFactory.create();
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .build();
    }
    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client,GsonConverterFactory gsonConverterFactory,RxJavaCallAdapterFactory rxJavaCallAdapterFactory){
        return new Retrofit.Builder()
                .baseUrl(BaseURl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .client(client)
                .build();
    }
    @Singleton
    @Provides
    Context provideContext(){
        return context;
    }
}
