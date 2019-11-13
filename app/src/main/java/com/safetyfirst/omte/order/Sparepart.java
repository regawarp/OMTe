package com.safetyfirst.omte.order;

import android.os.Parcel;
import android.os.Parcelable;

public class Sparepart implements Parcelable {
    private String name;
    private int idr;

    private Sparepart(Parcel in) {
        name = in.readString();
        idr = in.readInt();
    }

    public static final Creator<Sparepart> CREATOR = new Creator<Sparepart>() {
        @Override
        public Sparepart createFromParcel(Parcel in) {
            return new Sparepart(in);
        }

        @Override
        public Sparepart[] newArray(int size) {
            return new Sparepart[size];
        }
    };

    public Sparepart() {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(idr);
    }
}
