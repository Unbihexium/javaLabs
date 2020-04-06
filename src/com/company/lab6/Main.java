package com.company.lab6;

public class Main {

    public static void main(String[] args) {
	double k = 10.0;
	double[] arr = {1.0, 2.0, 3.0, 4.0};
	Pair1 pair = new Pair1(arr,k);
	System.out.println("Ответ: " + pair.findLog());
    }
}
