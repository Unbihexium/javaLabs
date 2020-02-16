package com.company.lab1;

import com.company.lab1.Lab1;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isRunning = true;
        Scanner in = new Scanner(System.in);

        while (isRunning){
            System.out.println("Введите номер задачи");
            switch (in.nextInt()){
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    task6();
                    break;
                case 7:
                    task7();
                    break;
                case 8:
                    task8();
                    break;
                case 9:
                    task9();
                    break;
                case 10:
                    task10();
                    break;
                case 11:
                    task11();
                    break;
                case 12:
                    task12();
                    break;
                default:
                    isRunning = false;
                    break;
            }
        }

    }

    public static void task1() {
        System.out.println(Lab1.begin25(14.0d));
        System.out.println(Lab1.begin25(26.0d));
        System.out.println(Lab1.begin25(0.0d));
    }

    public static void task2(){
        System.out.println(Lab1.if25(1));
        System.out.println(Lab1.if25(2));
        System.out.println(Lab1.if25(3));
    }

    public static void task3(){
        System.out.println(Lab1.for25(0.2d, 5));
        System.out.println(Lab1.for25(0.67d, 10));
        System.out.println(Lab1.for25(2.67d, 10));
    }

    public static void task4(){
        System.out.println(Lab1.while25(4));
        System.out.println(Lab1.while25(5));
        System.out.println(Lab1.while25(6));
    }

    public static void task5(){
        Lab1.minmax25(5);
        Lab1.minmax25(5);
        Lab1.minmax25(5);
    }

    public static void task6(){
        System.out.println(Lab1.array25(new int[]{1,3,9,27}));
        System.out.println(Lab1.array25(new int[]{1,2,4,8}));
        System.out.println(Lab1.array25(new int[]{1,2,4,9}));
    }

    public static void task7(){
        Lab1.array42(5.2d, 17);
        Lab1.array42(0.2d, 23);
        Lab1.array42(18.8d, 5);
    }

    public static void task8(){
        Lab1.array89(new double[]{9.0d, 8.0d, 7.0d, 6.0d, 4.0d, 5.0d, 3.0d, 2.0d, 1.0d});
    }

    public static void task9(){
        Lab1.matrix25(new int[][]{
                {1, 2, 34},
                {1, 2, 2},
                {1 ,2 ,2}
        });
    }

    public static void task10(){
        Lab1.string37("pararapa", "ra", "pi");
    }

    public static void task11(){
        Lab1.string66("Программа");
    }

    public static void task12(){
        try {
            Lab1.text25(1);
            Lab1.text25(2);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
