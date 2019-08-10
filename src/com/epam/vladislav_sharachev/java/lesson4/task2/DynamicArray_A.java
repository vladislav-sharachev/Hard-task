package com.epam.vladislav_sharachev.java.lesson4.task2;

import java.util.Arrays;
import java.util.Collections;

public class DynamicArray_A {

    public DynamicArray_A(int myValue) { //конструктор
        this.data = new Object[myValue];
    }
    public Object[] data;
    public int size = 0;

    public int size() { //размер массива
        return size;
    }

    public Object get(int size) { //получение элемента по индексу
        return data[size];
    }


public int add_million (int million) {
    for (int i = 0; i < 20; i++) { //генерирация числа
        System.out.print("[" + i + "] "); // вывести на экран последовательность чисел
        Collections.shuffle(Arrays.asList(size));
    }
    return 0;
}

 public int add_million1 (int million1) {
     Collections.shuffle(Arrays.asList(data));
        return 0;
    }





    public static void main(String[] args) {

DynamicArray_A vector = new DynamicArray_A(20);


        vector.add_million(20);
        System.out.println();
        vector.add_million1(20);
        System.out.println(vector.get(2));

    }
}