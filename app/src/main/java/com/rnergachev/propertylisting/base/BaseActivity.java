package com.rnergachev.propertylisting.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Base activity class which supports view holders for children fragments
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static final String VIEW_HOLDER = "VIEW_HOLDER";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize view model holder
        getViewModelHolder();
    }

    /**
     * Provides view model holder
     * @return {@link ViewModelHolder}
     */
    ViewModelHolder getViewModelHolder() {
        FragmentManager fm = getSupportFragmentManager();
        ViewModelHolder vh = (ViewModelHolder) fm.findFragmentByTag(VIEW_HOLDER);
        if (vh == null) {
            vh = new ViewModelHolder();
            fm.beginTransaction()
                .add(vh, VIEW_HOLDER)
                .commitNow();
        }

        return vh;
    }
}
