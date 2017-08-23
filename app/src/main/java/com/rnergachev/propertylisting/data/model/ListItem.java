package com.rnergachev.propertylisting.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Representation of the single item in the list
 */
public class ListItem implements Parcelable {

    private String id;
    private String text;

    public ListItem(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(text);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ListItem createFromParcel(Parcel in) {
            return new ListItem(in.readString(), in.readString());
        }

        @Override
        public Object[] newArray(int size) {
            return new ListItem[size];
        }
    };
}
