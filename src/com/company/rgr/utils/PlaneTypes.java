package com.company.rgr.utils;

public enum PlaneTypes {
    CARGO("CargoPlane"),
    PASSENGER("PassengerPlane"),
    FIREFIGHTER("FireFighterPlane");

    private String label;

    PlaneTypes(String label) {
        this.label = label;
    }

    public String toString() {
        return label;
    }
}
