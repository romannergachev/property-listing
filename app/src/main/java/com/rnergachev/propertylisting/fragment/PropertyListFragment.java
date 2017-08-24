package com.rnergachev.propertylisting.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rnergachev.propertylisting.PropertyApplication;
import com.rnergachev.propertylisting.R;
import com.rnergachev.propertylisting.activity.MainActivity;
import com.rnergachev.propertylisting.adapter.ListAdapter;
import com.rnergachev.propertylisting.base.BaseFragment;
import com.rnergachev.propertylisting.data.model.PropertyItem;
import com.rnergachev.propertylisting.handler.ListClickHandler;
import com.rnergachev.propertylisting.handler.ProgressHandler;
import com.rnergachev.propertylisting.viewmodel.PropertyListViewModel;

import fr.castorflex.android.circularprogressbar.CircularProgressBar;

/**
 * List fragment with properties
 */
public class PropertyListFragment extends BaseFragment<PropertyListViewModel> implements ListClickHandler, ProgressHandler {
    private RecyclerView list;
    private CircularProgressBar progressBar;

    @Override
    protected int getLayoutId() {
        return R.layout.list_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list = view.findViewById(R.id.list);
    }

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

        progressBar = getActivity().findViewById(R.id.progress_bar);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        list.setLayoutManager(layoutManager);
        list.setAdapter(new ListAdapter(getViewModel(), this));
        getViewModel().setProgressHandler(this);
        getViewModel().loadProperty();
    }

    @Override
    public void onClick(PropertyItem item) {
        ((MainActivity) getActivity()).openPropertyDetailFragment(item);
    }

    @Override
    public void startProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
