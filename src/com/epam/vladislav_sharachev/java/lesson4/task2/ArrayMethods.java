package com.epam.vladislav_sharachev.java.lesson4.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public  class ArrayMethods<Integer> {

    public final ArrayList<java.lang.Integer> one;

    public ArrayMethods(ArrayList<java.lang.Integer> one) {
        this.one = one;
    }

    public void getAdd() {
        for (int i = 0; i < 1000000; i++) {
            boolean add = one.add(i);//добавляем числа в массив
        }
    }

    public void getMix() {
        Collections.shuffle(one); //перемешиваем числа в массиве
        for (int i = 0; i < 10; i++) {
            System.out.print("[" + one.get(i) + "] "); //вывести на экран массив 10 первых чисел
        }
        System.out.println();
        System.out.println();
    }

    public void getUnique() {
        ArrayList<java.lang.Integer> myMilli = new ArrayList(Arrays.asList(one));
        /* создаем отдельный список
         для проверки уникальности каждого элемента массива */
        System.out.print(Collections.disjoint(myMilli, one)); //вывести на экран подтверждение уникальности
        System.out.println();
        System.out.println();
    }

    public void getMin() {
        System.out.print(Collections.min(one)); //вывести на экран минимальный элемент массива
        System.out.println();
        System.out.println();
    }

    public void getParity() {
        one.removeIf(i -> i % 2 != 0); //удалить все нечетные числа
        System.out.println(one); // вывести на экран все четные числа
        System.out.println();
    }

    public void getPenult() {
        Collections.sort(one); // отсортировать массив
            System.out.println(one.get(1)); //вывести на экран предпоследний элемент
        }
    }