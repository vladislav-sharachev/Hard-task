package com.epam.vladislav_sharachev.java.NewStudy.Sort;

public class Sort {

    private void swap(int[] array, int left, int right) {
        if (left != right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }

    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public void choiceSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i]; //предположим что самый маленький элемент - нулевой
            int min_i = i; // ищем в оставшейся части массива элемент, который меньше нулевого
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    min_i = j; // если есть элмемент который меньшн чем на текущей позиции - меняем их местами
                }
            }
            if (i != min_i) {
                int temp = array[i];
                array[i] = array[min_i];
                array[min_i] = temp;
            }
        }
    }

}
