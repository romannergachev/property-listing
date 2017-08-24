package com.rnergachev.propertylisting.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.rnergachev.propertylisting.R;
import com.rnergachev.propertylisting.base.BaseActivity;
import com.rnergachev.propertylisting.fragment.PropertyListFragment;

/**
 * Main activity for fragment circulation
 */
public class MainActivity extends BaseActivity {

    private final static String PROPERTY_LIST_FRAGMENT = "PROPERTY_LIST";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);

        if (getSupportFragmentManager().findFragmentByTag(PROPERTY_LIST_FRAGMENT) == null) {
            getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_list_container, PropertyListFragment.newInstance(), PROPERTY_LIST_FRAGMENT)
                .addToBackStack(null)
                .commit();
        }
    }
}
