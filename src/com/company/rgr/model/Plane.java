package com.company.rgr.model;

public class Plane {

    private String name;
    private String manufacturer;

    private double fuelCapacity;

    private int passengerCapacity;

    public Plane(String name, String manufacturer, double fuelCapacity, int passengerCapacity) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.fuelCapacity = fuelCapacity;
        this.passengerCapacity = passengerCapacity;
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
}
