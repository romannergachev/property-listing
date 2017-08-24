package com.rnergachev.propertylisting.data.network.response;

import com.google.gson.annotations.SerializedName;
import com.rnergachev.propertylisting.data.model.ListItem;

import java.util.List;

/**
 * Response of and API for the request of properties
 */
public class APIResponse {
    private class ListingResult {
        @SerializedName("Listings")
        private List<ListItem> listing;
    }

    @SerializedName("ListingResults")
    private ListingResult result;

    public APIResponse() {
    }

    public List<ListItem> getListing() {
        return result.listing;
    }
}
