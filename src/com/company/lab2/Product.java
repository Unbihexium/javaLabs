package com.company.lab2;

import java.util.Arrays;

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

    public Product(Product product){
        this.id = product.id;
        this.name = product.name;
        this.upc = product.upc;
        this.manufacturer = product.manufacturer;
        this.cost = product.cost;
        this.shelfLife = product.shelfLife;
        this.count = product.count;
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


    public static Product[] filterByName(Product[] products, String name){
        return Arrays.stream(products).filter(x -> x.name.equals(name)).toArray(Product[]::new);
    }

    public static Product[] filterByNameAndPrice(Product[] products, String name, double price){
        return Arrays.stream(filterByName(products, name)).filter(x -> x.cost <= price).toArray(Product[]::new);
    }

    public static Product[] filterByShelfLife(Product[] products, int days){
        return Arrays.stream(products).filter(x -> x.shelfLife >= days).toArray(Product[]::new);
    }

    @Override
    public String toString() {
        return this.name+ "("+ this.id + ")"+ "Cost:" + this.cost;
    }
}
