package com.rnergachev.propertylisting.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.rnergachev.propertylisting.R;
import com.rnergachev.propertylisting.base.BaseActivity;
import com.rnergachev.propertylisting.data.model.PropertyItem;
import com.rnergachev.propertylisting.fragment.PropertyDetailFragment;
import com.rnergachev.propertylisting.fragment.PropertyListFragment;

/**
 * Main activity for fragment circulation
 */
public class MainActivity extends BaseActivity {

    private final static String PROPERTY_LIST_FRAGMENT = "PROPERTY_LIST";
    private final static String PROPERTY_DETAIL_FRAGMENT = "PROPERTY_DETAIL";

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

    public void openPropertyDetailFragment(PropertyItem item) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
            .detach(fm.findFragmentByTag(PROPERTY_LIST_FRAGMENT))
            .add(R.id.fragment_list_container, PropertyDetailFragment.newInstance(item), PROPERTY_LIST_FRAGMENT)
            .addToBackStack(null)
            .commit();
    }
}
