package com.rnergachev.propertylisting.data.network;

import com.rnergachev.propertylisting.data.network.response.APIResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit api definition
 */
public interface PropertyApi {
    /**
     * Returns properties
     *
     * @return {@link Single<APIResponse>}
     */
    @GET("mapsearch")
    Single<APIResponse> getProperties(@Query("mode") String mode, @Query("sub") String sub,
                                      @Query("pcodes") String pcodes, @Query("state") String state);
}
