package com.company.rgr.model;

public class Plane {

    private String model;
    private String manufacturer;

    private double fuelConsumption;

    private int passengerCapacity;

    private double carryingCapacity;

    private double rangeOfFlight;

    public Plane(String model, String manufacturer, double fuelConsumption, int passengerCapacity, double carryingCapacity, double rangeOfFlight) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.fuelConsumption = fuelConsumption;
        this.passengerCapacity = passengerCapacity;
        this.carryingCapacity = carryingCapacity;
        this.rangeOfFlight = rangeOfFlight;
    }

    public Plane() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public double getRangeOfFlight() {
        return rangeOfFlight;
    }

    public void setRangeOfFlight(double rangeOfFlight) {
        this.rangeOfFlight = rangeOfFlight;
    }
}
