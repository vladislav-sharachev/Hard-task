package com.epam.vladislav_sharachev.java.NewStudy;

public class BubbleSort {
    private static void swap(int[] array, int left, int right) {
        if (left != right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }
    private static void bubble(int[]array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 100, 10, 20, 50, 43};
        bubble(array);
        for (int allValue : array) {
            System.out.print("[" + allValue + "] ");
        }
    }
}
