package com.rnergachev.propertylisting.viewmodel;


import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.util.Log;

import com.rnergachev.propertylisting.base.viewmodel.RxViewModel;
import com.rnergachev.propertylisting.data.PropertyRepo;
import com.rnergachev.propertylisting.data.model.PropertyItem;

import javax.inject.Inject;

/**
 * Properties list view model
 */
public class PropertyDetailViewModel extends RxViewModel {
    public final ObservableField<PropertyItem> item;

    @Inject
    public PropertyDetailViewModel() {
        item = new ObservableField<>();
    }
}
