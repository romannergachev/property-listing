package com.rnergachev.propertylisting.data.network.response;

import com.google.gson.annotations.SerializedName;
import com.rnergachev.propertylisting.data.model.PropertyItem;

import java.util.List;

/**
 * Response of and API for the request of properties
 */
public class APIResponse {
    private class ListingResult {
        @SerializedName("Listings")
        private List<PropertyItem> listing;
    }

    @SerializedName("ListingResults")
    private ListingResult result;

    public APIResponse() {
    }

    public APIResponse(List<PropertyItem> items) {
        result = new ListingResult();
        result.listing = items;
    }


    public List<PropertyItem> getListing() {
        return result.listing;
    }
}
