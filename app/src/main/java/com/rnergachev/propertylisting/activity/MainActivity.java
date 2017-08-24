package com.rnergachev.propertylisting.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

        Fragment listFragment = getSupportFragmentManager().findFragmentByTag(PROPERTY_LIST_FRAGMENT);
        if (listFragment == null) {
            listFragment = PropertyListFragment.newInstance();
        }

        Fragment detailFragment = getSupportFragmentManager().findFragmentByTag(PROPERTY_DETAIL_FRAGMENT);
        if (detailFragment != null) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_list_container, listFragment, PROPERTY_LIST_FRAGMENT)
                .addToBackStack(null)
                .commit();
        } else {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_list_container, listFragment, PROPERTY_LIST_FRAGMENT)
                .addToBackStack(null)
                .commit();
        }

    }

    public void openPropertyDetailFragment(PropertyItem item) {
        FragmentManager fm = getSupportFragmentManager();

        if (findViewById(R.id.fragment_detail_container) == null) {
            fm.beginTransaction()
                .replace(R.id.fragment_list_container, PropertyDetailFragment.newInstance(item), PROPERTY_DETAIL_FRAGMENT)
                .addToBackStack(null)
                .commit();
        } else {
            fm.beginTransaction()
                .add(R.id.fragment_detail_container, PropertyDetailFragment.newInstance(item), PROPERTY_DETAIL_FRAGMENT)
                .commit();
        }
    }
}
