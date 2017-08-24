package com.rnergachev.propertylisting.handler;

import com.rnergachev.propertylisting.data.model.PropertyItem;

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
    void onClick(PropertyItem item);
}
