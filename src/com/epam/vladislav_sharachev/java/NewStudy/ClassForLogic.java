package com.epam.vladislav_sharachev.java.NewStudy;

import com.epam.vladislav_sharachev.java.NewStudy.Sort.Sort;

public class ClassForLogic {

    int[] array = new int[]{2, 7, 4, 3, 50, 2};

    public void firstArrayMessage() {
        System.out.println("Первоначальный массив: ");
        for (int allValue : array) {
            System.out.print("[" + allValue + "] ");
        }
        System.out.println();
        System.out.println("Отсортированный массив: ");
    }

    public void findMax(int[] array) {
        int max = 0;
        for (int maxValue : array) { // ищем самое последнее число
            max = maxValue;
            System.out.print("[" + max + "] ");
        }
        System.out.println();
        System.out.println("Наибольшое число массива: " + max);
    }

    public void findMin(int[] array) {
        int min = array[0]; // min - самый первый элемент массива
        for (int minValue : array) {
            if (minValue < array[0]) { // если какое-то число меньше первого, то оно является минимальным
                min = minValue;
            }
        }
        System.out.println("Наименьшее число массива: " + min);
    }
}
