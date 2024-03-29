package com.safetyfirst.omte.model;

import com.google.firebase.firestore.GeoPoint;

public class Technician {
    private String techId;
    private String techName;
    private GeoPoint techLatLong;
    private String techEmail;
    private String techPhone;
    private boolean techAvailability;
    private String techPicture;

    public Technician() {
    }

    public Technician(String techId, String techName) {
        this.techId = techId;
        this.techName = techName;
    }

    public String getTechId() {
        return techId;
    }

    public String getTechName() {
        return techName;
    }

    public String getTechEmail() {
        return techEmail;
    }

    public String getTechPhone() {
        return techPhone;
    }

    public boolean isTechAvailability() {
        return techAvailability;
    }

    public String getTechPicture() {
        return techPicture;
    }

    public GeoPoint getTechLatLong() {
        return techLatLong;
    }
}
