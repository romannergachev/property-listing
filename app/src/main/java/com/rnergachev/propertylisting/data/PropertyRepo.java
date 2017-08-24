package com.rnergachev.propertylisting.data;

import com.rnergachev.propertylisting.data.network.PropertyApi;
import com.rnergachev.propertylisting.data.network.response.APIResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Property repo to convert API results for VM consumer
 */
public class PropertyRepo {
    private PropertyApi api;

    private static final String MODE = "buy";
    private static final String SUB = "Bondi";
    private static final String PCODES = "2026";
    private static final String STATE = "NSW";

    @Inject
    public PropertyRepo(PropertyApi api) {
        this.api = api;
    }

    /**
     * Load properties
     *
     * @return {@link Single} of {@link APIResponse} with list of properties
     */
    public Single<APIResponse> getProperties() {
        return api.getProperties(MODE, SUB, PCODES, STATE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }
}
