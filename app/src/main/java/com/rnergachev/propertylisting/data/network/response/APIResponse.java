package com.rnergachev.propertylisting.data.network.response;

import com.rnergachev.propertylisting.data.model.ListItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * Response of and API for the request of properties
 */

public class APIResponse {

    private int page;
    private int pageSize;
    private int totalPageCount;

    private HashMap<String, String> wkda;

    public APIResponse(int page, int pageSize, int totalPageCount, HashMap<String, String> wkda) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalPageCount = totalPageCount;
        this.wkda = wkda;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public List<ListItem> getItems() {
        List<ListItem> items = new ArrayList<>(wkda.size());
        for (Entry<String, String> entry : wkda.entrySet()) {
            items.add(new ListItem(entry.getKey(), entry.getValue()));
        }

        return items;
    }
}
