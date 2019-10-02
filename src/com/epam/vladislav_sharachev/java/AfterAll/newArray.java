package com.epam.vladislav_sharachev.java.AfterAll;

import java.lang.reflect.Array;
import java.util.Arrays;

public class newArray {
    public static void main(String[] args) {
        int[] myArray = {4, 10, 1, 20};
        Arrays.sort(myArray);
        System.out.println(myArray[0] + " " + myArray[1] + " " + myArray[2] + " " + myArray[3]);
        for (int i = 0; i < myArray.length; i++) {
            int min = myArray[0];
            int max = i = myArray.length;
            System.out.println("max: " + max + " min: " + min);
        }
    }
}
