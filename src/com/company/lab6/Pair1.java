package com.company.lab6;

import java.util.Arrays;

public class Pair1<T> {
    private T a;
    private T b;

    public Pair1(T a, T b) {
        this.a = a;
        this.b = b;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public T getB() {
        return b;
    }

    public void setB(T b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Pair1{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public double findLog(){
        double result =  Arrays.stream((double[]) this.a).sum() * (Double)this.b;
        return Math.log(Math.abs(result));
    }

}