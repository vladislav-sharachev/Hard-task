package com.epam.vladislav_sharachev.java.lesson4.task2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;

public class DynamicArray<E> {


    public static void main(String[] args) {

        ArrayList<Integer> myMillion = new ArrayList<>(Arrays.asList()); //создаем массив с 1 000 000 пустых строк
        for (int i = 0; i < 10; i++) {
            myMillion.add(i); //добавляем числа в массив
        }

        List sublist = myMillion.subList(0, 10); // диапазон массива
        sublist.forEach(e -> System.out.print(e)); //вывести на экран массив #1
        System.out.println();

        Collections.shuffle(myMillion); //перемешиваем числа в массиве
        for (int i = 0; i < 10; i++) {
            System.out.print(myMillion.get(i)); //вывести на экран массив #2
        }
        ArrayList<Integer> myMilli = new ArrayList(Arrays.asList(myMillion)); /* создаем отдельный список
         для проверки уникальности каждого элемента массива */


        System.out.println();
        System.out.print(Collections.disjoint(myMilli, myMillion)); //вывести на экран подтверждение уникальности
        System.out.println();
        System.out.print(Collections.min(myMillion)); //вывести на экран минимальный элемент массива

        for (int i = 0; i < myMillion.get(i); i++)
            if (myMillion.get(i) % 2 != 0) {

            }
        System.out.println();
        System.out.println( "Всего нечетных элементов = " + myMillion );
}
}