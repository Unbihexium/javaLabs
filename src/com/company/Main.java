package com.company;

import com.company.lab3.Triangle;
import com.company.lab1.Lab1;
import com.company.lab2.Product;

import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
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

    public static void task8(){
        Lab1.array89(new double[]{9.0d, 8.0d, 7.0d, 6.0d, 4.0d, 5.0d, 3.0d, 2.0d, 1.0d});
    }

    public static void task9(){
        Lab1.matrix25(new int[][]{
                {1, 2, 34},
                {1, 2, 2},
                {1 ,2 ,2}
        });
    }

    public static void task10(){
        Lab1.string37("pararapa", "ra", "pi");
    }
}
