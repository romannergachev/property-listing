package com.rnergachev.propertylisting.viewmodel;


import android.databinding.ObservableArrayList;
import android.util.Log;

import com.rnergachev.propertylisting.base.viewmodel.RxViewModel;
import com.rnergachev.propertylisting.data.PropertyRepo;
import com.rnergachev.propertylisting.data.model.PropertyItem;

import javax.inject.Inject;

/**
 * Properties list view model
 */
public class PropertyListViewModel extends RxViewModel {
    public final ObservableArrayList<PropertyItem> items;

    private final PropertyRepo repo;

    @Inject
    public PropertyListViewModel(PropertyRepo repo) {
        items = new ObservableArrayList<>();
        this.repo = repo;
    }

    /**
     * Loads properties into list
     */
    public void loadProperty() {
        if (items.size() > 0) {
            return;
        }
        subscriptions.add(repo.getProperties().subscribe(
            response -> items.addAll(response.getListing()),
            e -> Log.e(getClass().getName(), "Loading failed", e)
        ));
    }
}
