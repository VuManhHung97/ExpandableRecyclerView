package com.driscan.expandablerecyclerview.data.model;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Child implements Parcelable {
    private String name;
    private Drawable userImage;

    public Child(Parcel in) {
        name = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Child(String name, Drawable userImage) {
        setName(name);
        setUserImage(userImage);
    }


    public Drawable getUserImage() {
        return userImage;
    }

    public void setUserImage(Drawable userImage) {
        this.userImage = userImage;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Child> CREATOR = new Parcelable.Creator<Child>() {
        @Override
        public Child createFromParcel(Parcel in) {
            return new Child(in);
        }

        @Override
        public Child[] newArray(int size) {
            return new Child[size];
        }
    };
}
