package com.safetyfirst.omte.model;

public class Sparepart {
    private String spareId;
    private String spareName;
    private String spareCategory;
    private int sparePrice;

    public Sparepart(String spareName, String spareCategory, int sparePrice) {
        this.spareName = spareName;
        this.spareCategory = spareCategory;
        this.sparePrice = sparePrice;
    }

    public String getSpareId() {
        return spareId;
    }

    public String getSpareName() {
        return spareName;
    }

    public String getSpareCategory() {
        return spareCategory;
    }

    public int getSparePrice() {
        return sparePrice;
    }
}
