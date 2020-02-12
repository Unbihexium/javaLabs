package com.company.lab2;

public class Product {

    private int id;
    private String name;
    private String upc;
    private String manufacturer;
    private double cost;

    private int shelfLife;
    private int count;

    public Product(int id, String name, String upc, String manufacturer, double cost, int shelfLife, int count) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.shelfLife = shelfLife;
        this.count = count;
    }

    private Product(){}

    //region Getters&Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    //endregion


    public Product[] createProductArray(Product... products){

        Product[] array = new Product[products.length];
        return array;
    }
}
