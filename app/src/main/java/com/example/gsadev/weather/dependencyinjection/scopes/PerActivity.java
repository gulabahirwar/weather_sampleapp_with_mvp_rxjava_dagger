package com.example.gsadev.weather.dependencyinjection.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by GSA Dev on 2/14/2018.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {

}
