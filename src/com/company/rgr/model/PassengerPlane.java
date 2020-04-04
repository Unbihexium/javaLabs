package com.company.rgr.model;

public class PassengerPlane extends CargoPlane {

    private int passengers;

    public PassengerPlane(String model, String manufacturer, double rangeOfFlight, int crew, double carryingCapacity,  int passengers) {
        super(model, manufacturer, rangeOfFlight, crew, carryingCapacity);
        this.passengers = passengers;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}