package com.company.lab1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Lab1 {

    public static double begin25(double x) {
        return 3 * Math.pow(x, 6) - 6 * Math.pow(x, 2) - 7;
    }

    public static int if25(int x) {
        if (x < -2 || x > 2)
            return 2 * x;
        else
            return -3 * x;
    }

    public static double for25(double x, int n) {
        double sum = 0.0d;

        for (int i = 1; i <= n; ++i) {
            sum += Math.pow(-1, i - 1) * Math.pow(x, i) / i;
        }
        return sum;
    }

    public static int while25(int n) {
        int num1 = 1, num2 = 1;
        while (num1 < n && num2 < n) {
            num1 = num1 + num2;
            if (num1 > n)
                return num1;
            num2 = num1 + num2;
            if (num2 > n)
                return num2;
        }
        return 0;
    }

    public static void minmax25(int n) {
        // Однопроходный алгоритм
        Random rnd = new Random();
        int num = 0, min;
        int[] arr = new int[n];
        arr[0] = rnd.nextInt();
        arr[1] = rnd.nextInt();

        min = arr[0] * arr[1];

        for (int i = 2; i < n; ++i) {
            arr[i] = rnd.nextInt();
            int mul = arr[i - 1] * arr[i];
            if (mul < min) {
                min = mul;
                num = i - 1;
            }
        }
        System.out.println("First:" + num + "\nSecond: " + (num + 1));
    }

    public static int array25(int[] progression) {


        int d = progression[1] / progression[0];

        for (int i = 2; i < progression.length; ++i) {
            if (progression[i - 1] * d != progression[i])
                return 0;
        }
        return d;
    }

    public static void array42(double r, int n) {
        int[] arr = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            arr[i] = rnd.nextInt();
        }
        double min = Math.abs(r - arr[0] + arr[1]);
        int num = 0;
        for (int i = 2; i < n; ++i) {
            if (Math.abs(r - arr[i - 1] + arr[i]) < min) {
                min = Math.abs(r - arr[i - 1] + arr[i]);
                num = i - 1;
            }
        }
        System.out.println("First elem:" + arr[num] + "\nSecond elem: " + arr[num + 1]);

    }

    public static void array89(double[] almostSorted) {
        int idx = 0;
        for (int i = 1; i < almostSorted.length; ++i) {
            if (almostSorted[i - 1] < almostSorted[i]) {
                idx = i;
                break;
            }
        }
        for (int i = idx ; i < almostSorted.length; ++i) {
            if (almostSorted[i - 1] < almostSorted[i]) {
                swap(almostSorted, i - 1, i);
            }
        }
        for (int i = 1; i < almostSorted.length; ++i) {
            System.out.println(almostSorted[i]);
        }
    }

    public static void swap(double[] array, int a, int b){
        double x = array[a];
        double y = array[b];
        array[b] = x;
        array[a] = y;
    }
    public static void matrix25(int[][] matrix){
        int maxSum = 0, maxNum = 0;
        for (int i = 0; i < matrix.length; ++i){
            int sum = 0;
            for (int j = 0; j < matrix[i].length; ++j){
                sum +=matrix[i][j];
            }
            if (i == 0){
                maxSum = sum;
                maxNum = i;
            }
            if (sum > maxSum){
                maxSum = sum;
                maxNum = i;
            }
        }
        System.out.println("MaxSum:" + maxSum + ", MaxNum:" + maxNum);
    }

    public static void string37(String s, String s1, String s2) {
        int index = s.lastIndexOf(s1);
        if (index == -1)
            return;
        System.out.println(s.substring(0, index) + s2 + s.substring(index+s1.length()));
    }


    public static void string66(String s) {
        String s1 = "", s2 = "";
        for (int i = 0; i < s.length(); ++i) {
            if (i % 2 == 0){
                s1 += s.charAt(i);
            } else {
                s2 += s.charAt(i);
            }
        }
        System.out.println(s2 + new StringBuilder(s1).reverse().toString());
    }


    public static void createTextFile() throws IOException{
        PrintWriter out = new PrintWriter(new FileWriter("Text.txt"));
        out.write("This section describes how to use the three exception handler components — the try, catch, and finally blocks — to write an exception handler. Then, the try-with-resources statement, introduced in Java SE 7, is explained. The try-with-resources statement is particularly suited to situations that use Closeable resources, such as streams.\n" +
                "\n" +
                "The last part of this section walks through an example and analyzes what occurs during various scenarios.\n" +
                "\n" +
                "\n" +
                "The following example defines and implements a class named ListOfNumbers. When constructed, ListOfNumbers creates an ArrayList that contains 10 Integer elements with sequential values 0 through 9. The ListOfNumbers class also defines a method named writeList, which writes the list of numbers into a text file called OutFile.txt. This example uses output classes defined in java.io, which are covered in Basic I/O.```");
        out.close();

    }
    public static void text25(int paragraphToDelete) throws IOException {
        createTextFile();
        var lines = Files.readAllLines(Path.of("Text.txt"));
        int countParagraphs = 1;
        for (int i = 0; i < lines.size(); ++i) {
            if (countParagraphs == paragraphToDelete){
                lines.remove(i);
                break;
            }
            if (lines.get(i).length() == 0){
                if (lines.get(i - 1).length() == 0)
                    continue;
                ++countParagraphs;

            }

        }
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
