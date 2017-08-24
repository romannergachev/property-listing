package com.rnergachev.propertylisting.viewmodel;

import android.databinding.ObservableArrayList;
import android.util.Log;

import com.rnergachev.propertylisting.base.viewmodel.RxViewModel;
import com.rnergachev.propertylisting.data.PropertyRepo;
import com.rnergachev.propertylisting.data.model.ListItem;
import com.rnergachev.propertylisting.data.network.response.APIResponse;

import io.reactivex.Single;

/**
 * General list view model
 */
public abstract class ListViewModel extends RxViewModel {
    public final ObservableArrayList<ListItem> items;

    protected final PropertyRepo repo;

    protected ListViewModel(PropertyRepo repo) {
        items = new ObservableArrayList<>();
        this.repo = repo;
    }

    protected void loadItems(Single<APIResponse> supplier) {
        subscriptions.add(supplier.subscribe(
            response -> items.addAll(response.getListing()),
            e -> Log.e(getClass().getName(), "Loading failed", e)
        ));
    }
}
