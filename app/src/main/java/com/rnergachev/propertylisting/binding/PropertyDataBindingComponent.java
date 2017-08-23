package com.rnergachev.propertylisting.binding;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingComponent;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Binding component for Picasso
 */
public class PropertyDataBindingComponent implements DataBindingComponent {
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).into(view);
    }
}
