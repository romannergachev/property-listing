package com.rnergachev.propertylisting.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rnergachev.propertylisting.R;
import com.rnergachev.propertylisting.base.adapter.DataBindingViewHolder;
import com.rnergachev.propertylisting.base.adapter.ObservableListAdapter;
import com.rnergachev.propertylisting.data.model.PropertyItem;
import com.rnergachev.propertylisting.handler.ListClickHandler;
import com.rnergachev.propertylisting.viewmodel.PropertyListViewModel;

/**
 * Recycler view adapter for items
 */
public class ListAdapter extends ObservableListAdapter<ListAdapter.ViewHolder> {

    private static final int ELITE    = 1;
    private static final int STANDARD = 0;

    private final PropertyListViewModel viewModel;
    private ListClickHandler handler;

    class ViewHolder extends DataBindingViewHolder<PropertyItem> implements View.OnClickListener {
        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            handler.onClick(item);
        }
    }

    public ListAdapter(PropertyListViewModel viewModel, ListClickHandler handler) {
        this.viewModel = viewModel;
        this.handler = handler;
        observeList(viewModel.items);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int layoutId = (viewType == ELITE) ? R.layout.elite_list_item : R.layout.standard_list_item;

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(viewModel.items.get(position));
    }

    @Override
    public int getItemCount() {
        return viewModel.items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return viewModel.items.get(position).isElite();
    }
}
