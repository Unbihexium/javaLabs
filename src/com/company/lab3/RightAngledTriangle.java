package com.company.lab3;

import com.company.lab3.Triangle;

public class RightAngledTriangle extends Triangle {

    private double square;

    public RightAngledTriangle(double a, double b, double c) {
        super(a, b, c);
        if (a * a + b * b != c * c)
            throw new RuntimeException("Треугольник не прямоугольный");

    }

    public double getSquare() {
        return square;
    }

    public double calcSquare(){
        this.square =  this.a * this.b / 2.0;
        return this.square;
    }

}
