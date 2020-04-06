package com.company.lab6;

public class Pair<T, S>{
    private T a;
    private S b;

    public Pair(T a, S b) {
        this.a = a;
        this.b = b;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public S getB() {
        return b;
    }

    public void setB(S b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
