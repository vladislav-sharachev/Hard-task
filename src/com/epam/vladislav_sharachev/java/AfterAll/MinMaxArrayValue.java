package com.epam.vladislav_sharachev.java.AfterAll;

import java.util.Arrays;

public class MinMaxArrayValue {

    private static void findMax(int[] array) {
        int max = 0;
        for (int maxValue : array) { // ищем самое последнее число
            max = maxValue;
        }
        System.out.println("Наибольшое число массива: " + max);
    }

    private static void findMin(int[] array) {
        int min = array[0]; // min - самый первый элемент массива
        for (int minValue : array) {
            if (minValue < array[0]) { // если какое-то число меньше первого, то оно является минимальным
                min = minValue;
            }
        }
        System.out.println("Наименьшее число массива: " + min);
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 4, 3, 50, 2};
        Arrays.sort(array); // сортируем массиив
        findMax(array); // метод ищущий наибольший элемент (последний в списке)
        findMin(array); //метод сравнивает все элементы с самым первым
    }
}
