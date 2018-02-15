package com.example.gsadev.weather.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.gsadev.weather.dependencyinjection.component.ApplicationComponent;
import com.example.gsadev.weather.weatherapplication.WeatherApplication;

import butterknife.ButterKnife;

/**
 * Created by GSA Dev on 2/13/2018.
 */

public abstract class BaseActivity extends AppCompatActivity{
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        onViewReady(savedInstanceState,getIntent());
    }

    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        //TO be used child activity
        resolveDaggerInjection();
    }

    protected void resolveDaggerInjection() {

    }
    protected ApplicationComponent getApplicationComponent(){
        WeatherApplication weatherApplication= (WeatherApplication) getApplication();
        return weatherApplication.getApplicationComponent();
    }

    protected void showDialog(String message){
        if (progressDialog==null){
            progressDialog=new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(true);
        }
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    protected void hideDialog(){
        if (progressDialog!=null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
    protected abstract int getContentView();

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}

