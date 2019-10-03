package com.epam.vladislav_sharachev.java.NewStudy;

import com.epam.vladislav_sharachev.java.NewStudy.Sort.Sort;

public class MainClass {

    public static void main(String[] args) {
        ClassForLogic logicClass = new ClassForLogic();
        Sort sort = new Sort();
        int[] array = new int[]{2, 7, 4, 3, 50, 2};

        logicClass.firstArrayMessage(array);
        sort.bubbleSort(array);
        logicClass.findMax(array); // метод ищущий наибольший элемент (последний в списке)
        logicClass.findMin(array); //метод сравнивает все элементы с самым первым
    }
}
