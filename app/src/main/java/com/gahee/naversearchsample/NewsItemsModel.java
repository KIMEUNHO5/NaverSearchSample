package com.gahee.naversearchsample;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class NewsItemsModel implements Parcelable {

    @SerializedName("items")
    private List<NewsModel> items;

    protected NewsItemsModel(Parcel in) {
    }

    public static final Creator<NewsItemsModel> CREATOR = new Creator<NewsItemsModel>() {
        @Override
        public NewsItemsModel createFromParcel(Parcel in) {
            return new NewsItemsModel(in);
        }

        @Override
        public NewsItemsModel[] newArray(int size) {
            return new NewsItemsModel[size];
        }
    };

    public List<NewsModel> getItems() {
        return items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
