package com.rnergachev.propertylisting.viewmodel;


import android.databinding.ObservableArrayList;
import android.util.Log;

import com.rnergachev.propertylisting.base.viewmodel.RxViewModel;
import com.rnergachev.propertylisting.data.PropertyRepo;
import com.rnergachev.propertylisting.data.model.PropertyItem;
import com.rnergachev.propertylisting.handler.ProgressHandler;

import javax.inject.Inject;

/**
 * Properties list view model
 */
public class PropertyListViewModel extends RxViewModel {
    public final ObservableArrayList<PropertyItem> items;

    private final PropertyRepo repo;
    private ProgressHandler handler;

    @Inject
    public PropertyListViewModel(PropertyRepo repo) {
        items = new ObservableArrayList<>();
        this.repo = repo;
    }

    public void setProgressHandler(ProgressHandler handler) {
        this.handler = handler;
    }

    /**
     * Loads properties into list
     */
    public void loadProperty() {

        if (items.size() > 0) {
            return;
        }
        handler.startProgress();
        subscriptions.add(repo.getProperties().subscribe(
            response -> {
                items.addAll(response.getListing());
                handler.stopProgress();
            },
            e -> {
                Log.e(getClass().getName(), "Loading failed", e);
                handler.stopProgress();
            }
        ));
    }
}
