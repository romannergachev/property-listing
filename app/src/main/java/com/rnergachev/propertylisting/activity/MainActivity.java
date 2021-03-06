package com.rnergachev.propertylisting.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.rnergachev.propertylisting.R;
import com.rnergachev.propertylisting.base.BaseActivity;
import com.rnergachev.propertylisting.data.model.PropertyItem;
import com.rnergachev.propertylisting.fragment.PropertyDetailFragment;
import com.rnergachev.propertylisting.fragment.PropertyListFragment;

/**
 * Main activity for fragment circulation
 */
public class MainActivity extends BaseActivity {

    private final static String PROPERTY_LIST_FRAGMENT   = "PROPERTY_LIST";
    private final static String PROPERTY_DETAIL_FRAGMENT = "PROPERTY_DETAIL";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);

        Fragment listFragment = getSupportFragmentManager().findFragmentByTag(PROPERTY_LIST_FRAGMENT);
        if (listFragment == null) {
            listFragment = PropertyListFragment.newInstance();
        }

        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_list_container, listFragment, PROPERTY_LIST_FRAGMENT)
            .addToBackStack(null)
            .commit();
    }

    public void openPropertyDetailFragment(PropertyItem item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
            .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);

        if (findViewById(R.id.fragment_detail_container) == null) {
            transaction.replace(R.id.fragment_list_container, PropertyDetailFragment.newInstance(item), PROPERTY_DETAIL_FRAGMENT)
                .addToBackStack(null);
        } else {
            transaction.replace(R.id.fragment_detail_container, PropertyDetailFragment.newInstance(item), PROPERTY_DETAIL_FRAGMENT);
        }

        transaction.commit();
    }
}
