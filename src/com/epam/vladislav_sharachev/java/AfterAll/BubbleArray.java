package com.epam.vladislav_sharachev.java.AfterAll;

public class BubbleArray {
    private int[] array; //массив
    private int elements; // элементы в массиве

    public BubbleArray(int max) { //конструктор класса
        array = new int[max]; // создан массив размером max
        elements = 0; //при создании масств содержит в себе ноль элементов
    }

    public void systemInput(int value) { //метод вставки элемента в массив
        array[elements] = value; //вставка значения в массив
        elements++; //размер массива увеличивается
    }
    public void systemOutput(int value) {
        for (int i = 0; i < elements; i++) {
            System.out.println(array[i] + " ");
            System.out.println("");
        }
        System.out.println("End");
    }
}
