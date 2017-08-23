package com.rnergachev.propertylisting.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rnergachev.propertylisting.R;
import com.rnergachev.propertylisting.adapter.ListAdapter;
import com.rnergachev.propertylisting.base.BaseFragment;
import com.rnergachev.propertylisting.handler.ListClickHandler;
import com.rnergachev.propertylisting.viewmodel.ListViewModel;

/**
 * Fragment to show general list
 */
public abstract class ListFragment<VM extends ListViewModel> extends BaseFragment<VM> implements ListClickHandler {

    private RecyclerView list;

    @Override
    protected int getLayoutId() {
        return R.layout.list_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list = (RecyclerView) view.findViewById(R.id.list);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        list.setLayoutManager(layoutManager);
        list.setAdapter(new ListAdapter(getViewModel(), this));
    }
}
