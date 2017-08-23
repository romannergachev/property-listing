package com.rnergachev.propertylisting.di;

import com.rnergachev.propertylisting.activity.MainActivity;
import com.rnergachev.propertylisting.fragment.PropertyListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Application component for dagger
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainActivity activity);
    void inject(PropertyListFragment fragment);
}
