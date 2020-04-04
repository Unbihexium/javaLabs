package com.company.rgr.model;

public class FireFighterPlane extends AbstractPlane {

    private double waterCapacity;

    public FireFighterPlane(String model, String manufacturer, double rangeOfFlight, int crew, double waterCapacity) {
        super(model, manufacturer, rangeOfFlight, crew);
        this.waterCapacity = waterCapacity;
    }

    public double getWaterCapacity() {
        return waterCapacity;
    }

    public void setWaterCapacity(double waterCapacity) {
        this.waterCapacity = waterCapacity;
    }
}
