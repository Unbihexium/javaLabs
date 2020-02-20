package com.company.lab3;

public abstract class AbstractTriangle {

    protected double a, b;

    protected double gamma;

    public AbstractTriangle(double a, double b, double gamma) {
        if (a == 0 || b == 0 || gamma == 0) {
            throw new RuntimeException("Такой треугольник не существует");
        }
        this.a = a;
        this.b = b;
        this.gamma = gamma;
    }

    private AbstractTriangle() {}

    public double getA() {
        return a;
    }

    public void setA(double a) {
        if (a == 0) {
            throw new RuntimeException("Такой треугольник не существует");
        }
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        if (b == 0) {
            throw new RuntimeException("Такой треугольник не существует");
        }
        this.b = b;
    }


    public void setGamma(double gamma) {
        this.gamma = gamma;
    }

    public double getGamma() {
        return gamma;
    }


    public abstract double perimeter();
//    {
//        return this.a + this.b + this.c;
//    }

    public abstract double square();

    public double getC(){
        return Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(gamma));
    }

    public double getAlpha(){
        double c = getC();
        return Math.acos((this.b * this.b + c * c - this.a * this.a) / (2 * b * c));
    }

    public double getBeta(){
        double c = getC();
        return Math.acos((this.a * this.a + c * c - this.b * this.b) / (2 * a * c));
    }

}
