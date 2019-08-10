package com.epam.vladislav_sharachev.java.lesson4.task2.tryA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TryNow<Integer> {

    public final ArrayList<java.lang.Integer> one;

    public TryNow(ArrayList<java.lang.Integer> one) {

        this.one = one;

    }

    public void add() {
        for (int i = 0; i < 10; i++) {
            boolean add = one.add(i);//добавляем числа в массив
            System.out.print("[" + i + "] "); // вывести на экран последовательность чисел
        }
    }

    public void notWas() {
        Collections.shuffle(one); //перемешиваем числа в массиве
        for (int i = 0; i < 10; i++) {
            System.out.print("[" + one.get(i) + "] "); //вывести на экран массив #2
        }
    }
}
