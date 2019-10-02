package com.epam.vladislav_sharachev.java.AfterAll;

public class Bubble {
    public static void newArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{62, 84, 32, 5, 0, 14, 52, 82, 58, 71};
        System.out.println("1st: " + array[0] + " " + array[1] + " " + array[2] + " " + array[3] + " " + array[4]);
        Bubble.newArray(array);
        System.out.println("Length of Array: " + array.length);
        System.out.println("new 1st: " + array[0] + " " + array[1] + " " + array[2] + " " + array[3] + " " + array[4]);
    }
}
