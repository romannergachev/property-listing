package com.rnergachev.propertylisting.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.transition.Transition;
import android.transition.TransitionInflater;

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

        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_list_container, listFragment, PROPERTY_LIST_FRAGMENT)
            .addToBackStack(null)
            .commit();
    }

    public void openPropertyDetailFragment(PropertyItem item) {
        FragmentManager fm = getSupportFragmentManager();



//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            // Inflate transitions to apply
//            Transition changeTransform = TransitionInflater.from(this).
//                inflateTransition(R.transition.change_image_transform);
//            Transition explodeTransform = TransitionInflater.from(this).
//                inflateTransition(android.R.transition.explode);
//
//            // Setup exit transition on first fragment
//            fragmentOne.setSharedElementReturnTransition(changeTransform);
//            fragmentOne.setExitTransition(explodeTransform);
//
//            // Setup enter transition on second fragment
//            fragmentTwo.setSharedElementEnterTransition(changeTransform);
//            fragmentTwo.setEnterTransition(explodeTransform);
//
//            // Find the shared element (in Fragment A)
//            ImageView ivProfile = (ImageView) findViewById(R.id.ivProfile);
//
//            // Add second fragment by replacing first
//            FragmentTransaction ft = getFragmentManager().beginTransaction()
//                .replace(R.id.container, fragmentTwo)
//                .addToBackStack("transaction")
//                .addSharedElement(ivProfile, "profile");
//            // Apply the transaction
//            ft.commit();
//        }

        if (findViewById(R.id.fragment_detail_container) == null) {
            fm.beginTransaction()
                .detach(fm.findFragmentByTag(PROPERTY_LIST_FRAGMENT))
                .add(R.id.fragment_list_container, PropertyDetailFragment.newInstance(item), PROPERTY_DETAIL_FRAGMENT)
                .addToBackStack(null)
                .commit();
        } else {
            fm.beginTransaction()
                .add(R.id.fragment_detail_container, PropertyDetailFragment.newInstance(item), PROPERTY_DETAIL_FRAGMENT)
                .addToBackStack(null)
                .commit();
        }
    }
}
