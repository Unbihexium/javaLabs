package com.company.lab7;

import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        // Умножить каждое четное число на первое отрицательное
        task1();

        // В трех магазинах продают некоторые виды товаров из имеющегося списка
        // Определить какими товарами торгуют в каждом магазине; какие товары продают
        // только в одном магазине; какие товары есть хотя бы в двух магазинах
        task2();
    }

    public static void task1(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

        var rnd = ThreadLocalRandom.current();
        for (int i = 0; i < 10; ++i){
            arrayList.add(rnd.nextInt(-50, 51));
            linkedList.add(rnd.nextInt(-50, 51));
            deque.add(rnd.nextInt(-50, 51));
        }
        var newArrayList = doTaskWithArrayList(arrayList);
        var newLinkedList = doTaskWithLinkedList(linkedList);
        var newDeque = doTaskWithArrayDeque(deque);


    }

    public static ArrayList<Integer> doTaskWithArrayList(ArrayList<Integer> list) {
        ArrayList<Integer> listCopy = new ArrayList<>(list);

        var it = listCopy.iterator();
        int negative = 0;
        while (it.hasNext()){
            negative = it.next();
            if (negative < 0)
                break;
        }
        for (int i = 0; i < listCopy.size(); ++i){
            if (i % 2 == 0){
                listCopy.set(i, listCopy.get(i) * negative);
            }
        }
        return listCopy;
    }

    public static LinkedList<Integer> doTaskWithLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> listCopy = new LinkedList<>(list);

        var it = listCopy.iterator();
        int negative = 0;
        while (it.hasNext()){
            negative = it.next();
            if (negative < 0)
                break;
        }
        for (int i = 0; i < listCopy.size(); ++i){
            if (i % 2 == 0){
                listCopy.set(i, listCopy.get(i) * negative);
            }
        }
        return listCopy;
    }

    public static ArrayDeque<Integer> doTaskWithArrayDeque(ArrayDeque<Integer> list) {
        ArrayDeque<Integer> listCopy = new ArrayDeque<>(list);

        var it = listCopy.iterator();
        int negative = 0;
        while (it.hasNext()){
            negative = it.next();
            if (negative < 0)
                break;
        }

        // Четные
        ArrayDeque<Integer> evenElements = new ArrayDeque<>();
        // Нечетные
        ArrayDeque<Integer> oddElements = new ArrayDeque<>();

        while (!listCopy.isEmpty()){
            evenElements.add(listCopy.pollFirst());
            oddElements.add(listCopy.pollFirst());
        }
        var resultingDeque = new ArrayDeque<Integer>();
        while(!evenElements.isEmpty() && !oddElements.isEmpty()){
            resultingDeque.add(evenElements.pollFirst() * negative);
            resultingDeque.add(oddElements.pollFirst());
        }
        return resultingDeque;
    }

    public static void task2(){
        // Shops
        Shop shop1 = new Shop("1 shop");
        Shop shop2 = new Shop("2 shop");
        Shop shop3 = new Shop("3 shop");

        // Products
        Product product1 = new Product("1 product");
        Product product2 = new Product("2 product");
        Product product3 = new Product("3 product");

        // Add to shop
        shop1.addProduct(product1);
        shop1.addProduct(product2);
        shop1.addProduct(product3);

        // Add to shop 2
        shop2.addProduct(product1);
        shop2.addProduct(product2);

        // Add to shop 3
        shop3.addProduct(product1);

        Shop[] shops = new Shop[]{shop1, shop2, shop3};

        Product[] products = new Product[]{product1, product2, product3};

        for (int i = 0; i < products.length; ++i){
            int count = 0;
            for (int j = 0; j < shops.length; ++j){
                if (shops[j].contains(products[i]))
                    ++count;
            }

            if (count == 3)
                System.out.println("Продукт \"" + products[i].getName() + "\" содержится во всех магазинах");
            // Ниже должно быть условие count >= 2, так как по заданию надо отобразить товар,
            // который есть "хотя бы в двух магазинах", то есть либо в двух, либо во всех.
            // Но смысла еще раз показывать товар, который есть во всех магазинах нет.
            if (count == 2)
                System.out.println("Продукт \"" + products[i].getName() + "\" содержится в двух магазинах");
            if (count == 1)
                System.out.println("Продукт \"" + products[i].getName() + "\" содержится в одном магазине");

        }
    }

}
