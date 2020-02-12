package com.company.lab3;

public class Triangle {

    protected double a, b, c;

    public Triangle(double a, double b, double c) {
        if (a <= b + c || b <= c + a || c <= a + b) {
            throw new RuntimeException("Такой треугольник не существует");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private Triangle() {
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double perimeter(){
        return this.a + this.b + this.c;
    }

    public double getAlphaAngle(){
        return 0.0d;
    }
}
