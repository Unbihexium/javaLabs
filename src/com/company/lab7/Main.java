package com.company.lab7;

import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        task1();
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


}
