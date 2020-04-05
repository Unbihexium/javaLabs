package com.company.rgr.model;

public abstract class AbstractPlane {

    private String model;
    private String manufacturer;

    private double rangeOfFlight;

    private int crew;

    public AbstractPlane(){}

    public AbstractPlane(String model, String manufacturer, double rangeOfFlight, int crew) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.rangeOfFlight = rangeOfFlight;
        this.crew = crew;
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

    public double getRangeOfFlight() {
        return rangeOfFlight;
    }

    public void setRangeOfFlight(double rangeOfFlight) {
        this.rangeOfFlight = rangeOfFlight;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }
}

