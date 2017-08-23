package com.rnergachev.propertylisting.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rnergachev.propertylisting.R;
import com.rnergachev.propertylisting.base.adapter.DataBindingViewHolder;
import com.rnergachev.propertylisting.base.adapter.ObservableListAdapter;
import com.rnergachev.propertylisting.data.model.ListItem;
import com.rnergachev.propertylisting.handler.ListClickHandler;
import com.rnergachev.propertylisting.viewmodel.ListViewModel;

/**
 * Recycler view adapter for items
 */
public class ListAdapter extends ObservableListAdapter<ListAdapter.ViewHolder> {

    private final ListViewModel viewModel;
    private ListClickHandler handler;

    class ViewHolder extends DataBindingViewHolder<ListItem> implements View.OnClickListener {
        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            handler.onClick(item);
        }
    }

    public ListAdapter(ListViewModel viewModel, ListClickHandler handler) {
        this.viewModel = viewModel;
        this.handler = handler;
        observeList(viewModel.items);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(viewModel.items.get(position));
    }

    @Override
    public int getItemCount() {
        return viewModel.items.size();
    }
}
