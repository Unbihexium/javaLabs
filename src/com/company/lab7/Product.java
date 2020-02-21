package com.company.lab7;

public class Product {

    private String name;

    public Product(String name) {
        this.name = name;
    }
    public Product getCopy(){
        return new Product(this.name);
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Product p = (Product) obj;
        return (this.name == p.name);
    }
}
