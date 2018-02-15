
package com.example.gsadev.weather.mvp.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WeatherResponse {

    @SerializedName("query")
    private Query mQuery;

    public Query getQuery() {
        return mQuery;
    }

    public void setQuery(Query query) {
        mQuery = query;
    }

}
