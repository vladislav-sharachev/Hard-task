package com.epam.vladislav_sharachev.java.lesson4.task2;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Dinamic {

    public Dinamic(int myValue) { //конструктор
        this.data = new Object[myValue];
    }
    public Object[] data;
    public int size = 0;

    private int size() {
        return size;
    }

    private Object getLast() {
        return data[size-1];
    }

    private void add(Object s) {
        if(data.length <= size) {
            Object[] tmp = data;
            data = new Object[size*2];
            for (int i = 0; i < tmp.length; i++) {
                data[i] = tmp[i];
            }
        }
        data[size] = s;
        size++;
    }

    public void add_million () {
        for (int i = 0; i < 20; i++) { //генерирация числа
            System.out.print("[" + i + "] "); // вывести на экран последовательность чисел
        }
    }

    public void add_million1 () {
        for (int i = 0; i < 20; i++) { //генерирация числа
            System.out.print("[" + i + "] "); // вывести на экран последовательность чисел
        }
    }


    private Object get(int i) {
        return data[size-1];
    }

    public static void main(String[] args) {
        Dinamic vector = new Dinamic(20);

        vector.add_million();
        System.out.println();
        vector.add_million1();
        System.out.println(vector.size());



    }
}
