package com.rnergachev.propertylisting.base.viewmodel;

import com.rnergachev.propertylisting.base.BaseViewModel;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Extension of the {@link BaseViewModel} to work with rx subscriptions
 */

public class RxViewModel implements BaseViewModel {

    protected CompositeDisposable subscriptions;

    public RxViewModel() {
        subscriptions = new CompositeDisposable();
    }

    @Override
    public void clear() {
        subscriptions.clear();
    }
}
