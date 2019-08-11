package com.epam.vladislav_sharachev.java.lesson4.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayMethods<Integer> {

    public final ArrayList<java.lang.Integer> number;

    public ArrayMethods(ArrayList<java.lang.Integer> number) {
        this.number = number;
    }

    public void Add() {
        for (int i = 1; i < 1000001; i++) {
            boolean add = number.add(i);//добавляем числа в массив
        }
    }

    public void Mix() {
        Collections.shuffle(number); //перемешиваем числа в массиве
        System.out.print("Первые 10 чисел: ");
        for (int i = 1; i < 11; i++) {
            System.out.print("[" + number.get(i) + "] "); //вывести на экран массив 10 первых чисел
        }
        System.out.println();
    }

    public void Unique() {
        ArrayList<java.lang.Integer> myMilli = new ArrayList(Arrays.asList(number));
        /* создаем отдельный список
         для проверки уникальности каждого элемента массива */
        System.out.print("Элементы уникальны: " + Collections.disjoint(myMilli, number)); //вывести на экран подтверждение уникальности
        System.out.println();
    }

    public void Min() {
        System.out.print("Минимальный элемент: " + Collections.min(number)); //вывести на экран минимальный элемент массива
        System.out.println();

    }

    public void Parity() {
        number.removeIf(i -> i % 2 != 0); //удалить все нечетные числа
    }

    public void Penult() {
        Collections.sort(number); // отсортировать массив
        System.out.println("Предпоследний по величине четный элемент: " + number.get(1)); //вывести на экран предпоследний элемент
    }
}