package com.example.gsadev.weather.modules.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.gsadev.weather.R;
import com.example.gsadev.weather.base.BaseActivity;
import com.example.gsadev.weather.dependencyinjection.component.DaggerWeatherComponent;
import com.example.gsadev.weather.dependencyinjection.module.WeatherModule;
import com.example.gsadev.weather.modules.home.adapter.RecyclerViewAdapter;
import com.example.gsadev.weather.mvp.model.Astronomy;
import com.example.gsadev.weather.mvp.model.Forecast;
import com.example.gsadev.weather.mvp.model.Location;
import com.example.gsadev.weather.mvp.presenter.WeatherPresenter;
import com.example.gsadev.weather.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements MainView{
    @Inject protected WeatherPresenter mWeatherPresenter;
    @Bind(R.id.recyclerView) protected RecyclerView recyclerView;


    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initializeList();
        mWeatherPresenter.getWeatherData();
    }

    private void initializeList() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void resolveDaggerInjection() {
        DaggerWeatherComponent.builder()
                .applicationComponent(getApplicationComponent())
                .weatherModule(new WeatherModule(this))
                .build().inject(this);
    }

    @Override
    public void getLoadForecast(List<Forecast> forecasts, Astronomy astronomy,Location location) {
        getSupportActionBar().setTitle("Location- "+location.getCity());
        recyclerView.setAdapter(new RecyclerViewAdapter(forecasts,astronomy));
    }

    @Override
    public void onLoading(String msg) {
        showDialog(msg);
    }

    @Override
    public void onLoadingComplete(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadingError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }
}
