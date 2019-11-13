package com.safetyfirst.omte.order;

import android.os.Parcel;
import android.os.Parcelable;

public class BrokenPart implements Parcelable {
    private String name;
    private int idr;

    public BrokenPart() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    private BrokenPart(Parcel in) {
        name = in.readString();
        idr = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(idr);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BrokenPart> CREATOR = new Creator<BrokenPart>() {
        @Override
        public BrokenPart createFromParcel(Parcel in) {
            return new BrokenPart(in);
        }

        @Override
        public BrokenPart[] newArray(int size) {
            return new BrokenPart[size];
        }
    };
}
