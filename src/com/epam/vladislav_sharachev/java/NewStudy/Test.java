package com.epam.vladislav_sharachev.java.NewStudy;

import java.util.Arrays;

public class Test {

    private static void findMax(int[] array) {
        int max = 0;
        for (int value : array) {
            max = value;
        }
        System.out.println(max);
    }

    private static void findMin(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (array[0] > value) {
                min = value;
            }
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 4, 3, 50, 1};
        System.out.println("Первоначальный массив: ");
        for (int allValue : array) {
            System.out.print("[" + allValue + "] ");
        }
        System.out.println();
        System.out.println("Отсортированный массив: ");
        Arrays.sort(array); // сортируем массиив
        findMax(array); // метод ищущий наибольший элемент (последний в списке)
        findMin(array); //метод сравнивает все элементы с самым первым
    }
}
