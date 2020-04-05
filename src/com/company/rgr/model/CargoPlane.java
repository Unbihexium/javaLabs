package com.company.rgr.model;

public class CargoPlane extends AbstractPlane {

    protected double carryingCapacity;

    public CargoPlane(){
        super();
    }

    public CargoPlane(String model, String manufacturer, double rangeOfFlight, int crew, double carryingCapacity) {
        super(model, manufacturer, rangeOfFlight, crew);
        this.carryingCapacity = carryingCapacity;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

}