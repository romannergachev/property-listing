package com.rnergachev.propertylisting.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.rnergachev.propertylisting.PropertyApplication;
import com.rnergachev.propertylisting.R;
import com.rnergachev.propertylisting.base.BaseFragment;
import com.rnergachev.propertylisting.data.model.PropertyItem;
import com.rnergachev.propertylisting.viewmodel.PropertyDetailViewModel;

/**
 * Property detail fragment draft
 */
public class PropertyDetailFragment extends BaseFragment<PropertyDetailViewModel> {
    private static final String PROPERTY_ARG = "PROPERTY";

    @Override
    protected int getLayoutId() {
        return R.layout.detail_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    public static Fragment newInstance(PropertyItem item) {
        Fragment fragment = new PropertyDetailFragment();

        Bundle args = new Bundle();
        args.putParcelable(PROPERTY_ARG, item);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    protected void injectDependencies() {
        ((PropertyApplication) getActivity().getApplication()).appComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getViewModel().item.set(getArguments().getParcelable(PROPERTY_ARG));
    }
}
