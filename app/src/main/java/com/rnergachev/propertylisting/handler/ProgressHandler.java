package com.rnergachev.propertylisting.handler;

/**
 * Progress bar handler
 *
 * Created by rnergachev on 24/08/2017.
 */
public interface ProgressHandler {
    /**
     * Starts progress bar
     */
    void startProgress();

    /**
     * Stops progress bar
     */
    void stopProgress();
}
