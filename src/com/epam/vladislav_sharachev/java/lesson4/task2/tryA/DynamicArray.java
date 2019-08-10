package com.epam.vladislav_sharachev.java.lesson4.task2.tryA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Integer;

public class DynamicArray<E> {


    public static void main(String[] args) {

        ArrayList<Integer> myMillion = new ArrayList(); //создаем массив с 1 000 000 пустых строк

        TryNow tryNow = new TryNow(myMillion);
        tryNow.add();
        System.out.println();
        System.out.println();
        tryNow.notWas();
        System.out.println();


        Collections.shuffle(myMillion); //перемешиваем числа в массиве
        for (int i = 0; i < 10; i++) {
            System.out.print("[" + myMillion.get(i) + "] "); //вывести на экран массив #2
        }
        ArrayList<Integer> myMilli = new ArrayList(Arrays.asList(myMillion)); /* создаем отдельный список
         для проверки уникальности каждого элемента массива */

        System.out.println();
        System.out.println();
        System.out.print(Collections.disjoint(myMilli, myMillion)); //вывести на экран подтверждение уникальности

        System.out.println();
        System.out.println();
        System.out.print(Collections.min(myMillion)); //вывести на экран минимальный элемент массива


        myMillion.removeIf(i -> i % 2 != 0); //удалить все нечетные числа

        System.out.println();
        System.out.println();
        System.out.println(myMillion); //вывести на экран все четные числа

        System.out.println();
        System.out.println();
        {
            if (myMillion.removeIf(i -> i % 2 != 0)) ;
            {
                System.out.print(Collections.min(myMillion)+1); // предпоследний по величине элемент
            }
        }
    }
}