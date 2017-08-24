package com.rnergachev.propertylisting.viewmodel;


import com.rnergachev.propertylisting.data.PropertyRepo;
import com.rnergachev.propertylisting.data.model.PropertyItem;
import com.rnergachev.propertylisting.data.network.response.APIResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * {@link PropertyListViewModel} unit test
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class PropertyListViewModelUnitTest {
    @Mock
    private PropertyRepo repo;
    private PropertyListViewModel vm;
    private APIResponse response;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        vm = new PropertyListViewModel(repo);

        List<PropertyItem> items = new ArrayList<>();
        items.add(new PropertyItem(1));
        items.add(new PropertyItem(2));
        response = new APIResponse(items);
    }

    @Test
    public void vm_should_load_manufacturers() throws InterruptedException {
        when(repo.getProperties())
            .thenReturn(Single.just(response));

        vm.loadProperty();

        verify(repo, atLeastOnce()).getProperties();
        assertEquals(2, vm.items.size());
    }
}
