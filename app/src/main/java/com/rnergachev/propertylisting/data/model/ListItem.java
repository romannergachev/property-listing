package com.rnergachev.propertylisting.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of the single item in the list
 */
public class ListItem implements Parcelable {
    @SerializedName("AgencyLogoUrl")
    private String agencyLogoUrl;
    @SerializedName("Bathrooms")
    private int bathrooms;
    @SerializedName("Bedrooms")
    private int bedrooms;
    @SerializedName("Carspaces")
    private int carspaces;
    @SerializedName("DisplayPrice")
    private String price;
    @SerializedName("DisplayableAddress")
    private String address;
    @SerializedName("TruncatedDescription")
    private String description;
    @SerializedName("RetinaDisplayThumbUrl")
    private String firstThumbUrl;
    @SerializedName("SecondRetinaDisplayThumbUrl")
    private String secondThumbUrl;
    @SerializedName("IsElite")
    private int isElite;

    public ListItem() {
    }

    public ListItem(String agencyLogoUrl, int bathrooms, int bedrooms,
                    int carspaces, String price, String address, String description,
                    String firstThumbUrl, String secondThumbUrl, int isElite) {
        this.agencyLogoUrl = agencyLogoUrl;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
        this.carspaces = carspaces;
        this.price = price;
        this.address = address;
        this.description = description;
        this.firstThumbUrl = firstThumbUrl;
        this.secondThumbUrl = secondThumbUrl;
        this.isElite = isElite;
    }

    public String getAgencyLogoUrl() {
        return agencyLogoUrl;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getCarspaces() {
        return carspaces;
    }

    public String getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getFirstThumbUrl() {
        return firstThumbUrl;
    }

    public String getSecondThumbUrl() {
        return secondThumbUrl;
    }

    public int getIsElite() {
        return isElite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.agencyLogoUrl);
        dest.writeInt(this.bathrooms);
        dest.writeInt(this.bedrooms);
        dest.writeInt(this.carspaces);
        dest.writeString(this.price);
        dest.writeString(this.address);
        dest.writeString(this.description);
        dest.writeString(this.firstThumbUrl);
        dest.writeString(this.secondThumbUrl);
        dest.writeInt(this.isElite);
    }

    protected ListItem(Parcel in) {
        this.agencyLogoUrl = in.readString();
        this.bathrooms = in.readInt();
        this.bedrooms = in.readInt();
        this.carspaces = in.readInt();
        this.price = in.readString();
        this.address = in.readString();
        this.description = in.readString();
        this.firstThumbUrl = in.readString();
        this.secondThumbUrl = in.readString();
        this.isElite = in.readInt();
    }

    public static final Creator<ListItem> CREATOR = new Creator<ListItem>() {
        @Override
        public ListItem createFromParcel(Parcel source) {
            return new ListItem(source);
        }

        @Override
        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };
}
