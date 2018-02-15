package com.example.gsadev.weather.base;


import com.example.gsadev.weather.mvp.view.BaseView;


import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by GSA Dev on 2/14/2018.
 */

public class BasePresenter<V extends BaseView> {

    @Inject
    protected  V view;

    public V getView() {
        return view;
    }

    protected <T> void subscribe(Observable<T> observable, Observer<T> observer){
      observable.subscribeOn(Schedulers.newThread())
              .single()
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(observer);
    }
}
