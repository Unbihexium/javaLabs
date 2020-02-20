package com.company.lab3;

public class Triangle {

    protected double a, b, c;

    protected double alpha, beta, gamma;

    public Triangle(double a, double b, double c) {
        if (a <= b + c || b <= c + a || c <= a + b) {
            throw new RuntimeException("Такой треугольник не существует");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        recalcAngles();
    }

    private Triangle() {
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        if (a <= b + c || b <= c + a || c <= a + b) {
            throw new RuntimeException("Такой треугольник не существует");
        }
        this.a = a;
        recalcAngles();
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        if (a <= b + c || b <= c + a || c <= a + b) {
            throw new RuntimeException("Такой треугольник не существует");
        }
        this.b = b;
        recalcAngles();
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        if (a <= b + c || b <= c + a || c <= a + b) {
            throw new RuntimeException("Такой треугольник не существует");
        }
        this.c = c;
        recalcAngles();
    }

    public double perimeter(){
        return this.a + this.b + this.c;
    }

    public void calcAlphaAngle(){
        this.alpha = Math.acos((this.b * this.b + this.c * this.c - this.a * this.a) / (2 * b * c));
    }

    public void calcBetaAngle(){
        this.beta = Math.acos((this.a * this.a + this.c * this.c - this.b * this.b) / (2 * a * c));
    }

    public void calcGammaAngle(){
        this.gamma = 180.0d - this.alpha - this.beta;
    }

    public void recalcAngles(){
        calcAlphaAngle();
        calcBetaAngle();
        calcGammaAngle();
    }

    public double getAlpha() {
        return alpha;
    }

    public double getBeta() {
        return beta;
    }

    public double getGamma() {
        return gamma;
    }

}
