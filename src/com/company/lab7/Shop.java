package com.company.lab7;

import java.util.ArrayList;

public class Shop {

    private String shopName;
    ArrayList<Product> products = new ArrayList<>();

    public String getShopName() {
        return shopName;
    }

    public Shop setShopName(String shopName) {
        this.shopName = shopName;
        return this;
    }

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    @Override
    public String toString() {
        return "Магазин " + this.shopName;
    }
}
