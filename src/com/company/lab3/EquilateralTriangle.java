package com.company.lab3;

public class EquilateralTriangle extends AbstractTriangle {

    public EquilateralTriangle(double a, double b, double gamma) {
        super(a, b, gamma);
    }

    @Override
    public double perimeter() {
        double c = getC();
        return a + b + c;
    }

    @Override
    public double square() {
        return a * b * Math.sin(gamma) / 2;
    }
}
