package com.rnergachev.propertylisting.viewmodel;


import com.rnergachev.propertylisting.data.PropertyRepo;

import javax.inject.Inject;

/**
 * Properties list view model
 */
public class PropertyListViewModel extends ListViewModel {

    @Inject
    public PropertyListViewModel(PropertyRepo repo) {
        super(repo);
    }

    /**
     * Loads properties into list
     */
    public void loadProperty() {
        loadItems(repo.getManufacturers());
    }
}
