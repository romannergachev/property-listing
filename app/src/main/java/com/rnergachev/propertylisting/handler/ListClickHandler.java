package com.rnergachev.propertylisting.handler;

import com.rnergachev.propertylisting.data.model.ListItem;

/**
 * List on click handler
 *
 */
public interface ListClickHandler {
    /**
     * Performs the item selection
     *
     * @param item that has been selected
     */
    void onClick(ListItem item);
}
