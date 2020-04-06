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
            if (x == 0 || x == 2 || x == -2)
                throw new ArithmeticException("/ by zero");
            double denom = 2 + (1 + x + x * x) / (2 * x + x * x) - (1 - x + x * x) / (2 * x - x * x);
            if (denom == 0)
                throw new ArithmeticException("/ by zero");
            double z1 = 1 / denom * (5 - 2 * x * x);
            System.out.println("Result z1:" + z1);
            double z2 = (4 - x * x) / 2;
            System.out.println("Result z2:" + z2);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }


    }

    public static void task2(){

    }

    // Функция выполянет деление комплексных чисел А и В.
    class ComplexNumber {
        // x + iy
        public double x;
        public double y;

        public ComplexNumber() {
            this.x = 0.0d;
            this.y = 0.0d;
        }
        public ComplexNumber(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public ComplexNumber dividedBy(ComplexNumber c) {
            double denom = c.x*c.x + c.y*c.y;
            try {
                if (denom == 0)
                    throw new ComplexNumberException("/ by zero in denominator");
                else
                    return new ComplexNumber((x * c.x + y * c.y) / denom, (y * c.x - x * c.y) / denom);
            } catch (ComplexNumberException e){
                e.printStackTrace();
                return null;
            }

        }

        public ComplexNumber dividedBy(double x) {
            try {
                if (x == 0)
                    throw new ComplexNumberException("/ by zero");
                else
                    return new ComplexNumber(this.x/x, this.y/x);
            } catch (ComplexNumberException e){
                e.printStackTrace();
                return null;
            }
        }
    }

    class ComplexNumberException extends Exception {

        public ComplexNumberException() {
            super();
        }

        public ComplexNumberException(String message) {
            super(message);
        }

        public ComplexNumberException(String message, Throwable cause) {
            super(message, cause);
        }

        public ComplexNumberException(Throwable cause) {
            super(cause);
        }

        protected ComplexNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
