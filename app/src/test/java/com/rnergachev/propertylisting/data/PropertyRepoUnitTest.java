package com.rnergachev.propertylisting.data;

import android.content.Context;

import com.rnergachev.propertylisting.data.model.PropertyItem;
import com.rnergachev.propertylisting.data.network.PropertyApi;
import com.rnergachev.propertylisting.data.network.response.APIResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * {@link PropertyRepo} unit test
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PropertyRepoUnitTest {
    @Mock
    private PropertyApi api;
    @Mock
    Context context;
    private PropertyRepo repo;
    private APIResponse response;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        repo = new PropertyRepo(api);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(__ -> Schedulers.trampoline());

        List<PropertyItem> items = new ArrayList<>();
        items.add(new PropertyItem(1));
        items.add(new PropertyItem(2));
        response = new APIResponse(items);
    }



    @Test
    public void repo_should_get_properties() {

        when(api.getProperties(anyString(), anyString(), anyString(), anyString()))
            .thenReturn(Single.just(response));

        TestObserver<APIResponse> testObserver = repo.getProperties().test();
        testObserver
            .awaitTerminalEvent();
        testObserver
            .assertNoErrors()
            .assertValue(resp -> resp.getListing().size() == response.getListing().size())
            .assertValue(resp -> resp.getListing().get(0).getId() == response.getListing().get(0).getId())
            .assertValue(resp -> resp.getListing().get(1).getId() == response.getListing().get(1).getId());
    }

    @After
    public void tearDown() {
        RxAndroidPlugins.reset();
    }
}
