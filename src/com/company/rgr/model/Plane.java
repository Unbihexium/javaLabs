package com.company.rgr.model;

public class Plane {

    private String name;
    private String manufacturer;

    private double fuelCapacity;

    private int passengerCapacity;

    private double carryingCapacity;

    private double rangeOfFlight;

    public Plane(String name, String manufacturer, double fuelCapacity, int passengerCapacity, double carryingCapacity, double rangeOfFlight) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.fuelCapacity = fuelCapacity;
        this.passengerCapacity = passengerCapacity;
        this.carryingCapacity = carryingCapacity;
        this.rangeOfFlight = rangeOfFlight;
    }

    private Plane() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
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
