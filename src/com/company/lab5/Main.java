package com.company.lab5;

import java.util.Scanner;
import java.lang.ArithmeticException;

public class Main {

    public static void main(String[] args){
        task1();
    }

    public static void task1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите x");
        double x = sc.nextDouble();
        try {
            if (x == 0)
                throw new ArithmeticException("/ by zero");
            double denum = 2 + (1 + x + x * x) / (2 * x + x * x) - (1 - x + x * x) / (2 * x - x * x);
            if (denum == 0)
                throw new ArithmeticException("/ by zero");
            double z1 = 1 / denum * (5 - 2 * x * x);
            System.out.println("Result z1:" + z1);
            double z2 = (4 - x * x) / 2;
            System.out.println("Result z2:" + z2);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }


    }
}
