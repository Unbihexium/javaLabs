package com.company.lab6;

public class Pair2<T>{
    private T a, b, c;

    public Pair2(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public T getC() {
        return c;
    }

    public void setC(T c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Pair2{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
