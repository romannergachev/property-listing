package com.rnergachev.propertylisting.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.rnergachev.propertylisting.BR;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Base Activity class with view model support
 */

public abstract class BaseViewModelActivity<VM extends BaseViewModel> extends BaseActivity implements BaseView {

    @Inject public Provider<VM> viewModelProvider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectDependencies();

        VM viewModel = getViewModel();
        ViewDataBinding binding = DataBindingUtil.setContentView(this, getLayoutId());
        binding.setVariable(BR.model, viewModel);
    }



    protected VM getViewModel() {
        ViewModelHolder vh = getViewModelHolder();
        VM vm = (VM) vh.getViewModel(this.getClass().getCanonicalName());
        if (vm == null) {
            vm = createViewModel();
            vh.attach(this.getClass().getCanonicalName(), vm);
        }

        return vm;
    }

    protected VM createViewModel() {
        return viewModelProvider.get();
    }

    /**
     * Provides layout id
     * @return layout id
     */
    protected abstract int getLayoutId();

    /**
     * Injects dependencies
     */
    protected abstract void injectDependencies();
}
