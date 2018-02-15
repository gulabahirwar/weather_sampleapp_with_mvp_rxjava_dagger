package com.example.gsadev.weather.modules.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gsadev.weather.R;
import com.example.gsadev.weather.mvp.model.Astronomy;
import com.example.gsadev.weather.mvp.model.Forecast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by GSA Dev on 2/15/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
   private List<Forecast> forecastList;
   private Astronomy astronomy;

   public RecyclerViewAdapter( List<Forecast> forecastList, Astronomy astronomy){
       this.forecastList=forecastList;
       this.astronomy=astronomy;
   }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(forecastList.get(position),astronomy);
    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
         @Bind(R.id.date) TextView mDate;
         @Bind(R.id.temperature) TextView mTemperature;
         @Bind(R.id.astronomy) TextView mAstronomy;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bind(Forecast forecast,Astronomy astronomy) {
           char tmp = 0x00B0;
           mDate.setText(forecast.getDate());
           mTemperature.setText(forecast.getLow()+tmp+"/"+forecast.getHigh()+tmp);
           mAstronomy.setText(astronomy.getSunrise()+"/"+astronomy.getSunset());

        }
    }
}
