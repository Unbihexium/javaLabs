package com.company.lab2;

public class Main {

    public static void main(String[] args){
        Product p1 = new Product(
                0,
                "Name",
                "9999",
                "Manufact",
                150.0d,
                100,
                100
        );
        Product p2 = new Product(
                1,
                "Name1",
                "9999",
                "Manufact",
                150.0d,
                110,
                100
        );
        Product p3 = new Product(
                2,
                "Name1",
                "9999",
                "Manufact",
                100.0d,
                100,
                100
        );
//        var result = Product.filterByNameAndPrice(new Product[]{p1, p2, p3}, "Name1", 100);
        var result = Product.filterByShelfLife(new Product[]{p1, p2, p3}, 101);
        for (Product p: result){
            System.out.println(p);
        }

    }
}
