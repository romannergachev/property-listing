package com.rnergachev.propertylisting.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.rnergachev.propertylisting.PropertyApplication;
import com.rnergachev.propertylisting.data.model.ListItem;
import com.rnergachev.propertylisting.viewmodel.PropertyListViewModel;

/**
 * List fragment with properties
 */
public class PropertyListFragment extends ListFragment<PropertyListViewModel> {

    public static Fragment newInstance() {
        return new PropertyListFragment();
    }

    @Override
    protected void injectDependencies() {
        ((PropertyApplication) getActivity().getApplication()).appComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getViewModel().loadProperty();
    }

    @Override
    public void onClick(ListItem item) {
        //((MainActivity) getActivity()).openDetail(item);
    }
}
