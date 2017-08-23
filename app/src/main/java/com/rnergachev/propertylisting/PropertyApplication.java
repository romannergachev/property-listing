package com.rnergachev.propertylisting;

import android.app.Application;
import android.databinding.DataBindingUtil;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.rnergachev.propertylisting.binding.PropertyDataBindingComponent;
import com.rnergachev.propertylisting.di.ApplicationComponent;
import com.rnergachev.propertylisting.di.ApplicationModule;
import com.rnergachev.propertylisting.di.DaggerApplicationComponent;
import com.squareup.picasso.Picasso;

/**
 * Application class, used to include dagger, picasso and define default data binding component
 *
 */
public class PropertyApplication extends Application {

    public ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        Picasso picasso = new Picasso.Builder(this)
            .downloader(new OkHttp3Downloader(this, Integer.MAX_VALUE))
            .indicatorsEnabled(false)
            .loggingEnabled(false)
            .build();
        Picasso.setSingletonInstance(picasso);
        DataBindingUtil.setDefaultComponent(new PropertyDataBindingComponent());
    }

}