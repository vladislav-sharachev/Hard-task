package com.epam.vladislav_sharachev.java.lesson4.task2.tryA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Integer;

public class DynamicArray<E> {


    public static void main(String[] args) {

        ArrayList<Integer> myMillion = new ArrayList(); //создаем массив
        TryNow tryNow = new TryNow(myMillion); //ссылка на конструктор с методами

        tryNow.getAdd(); // добавить числа в массив
        tryNow.getMix(); //перемешать и показать что числа перемешаны (случайные 10)
        tryNow.getUnique(); //создание 2-го массива для сравнения с 1-м (проверка уникальности)
        tryNow.getMin(); //вывести на экран минимальный элемент массива
        tryNow.getParity(); //удалить все нечетные числа вывести все четные числа
        tryNow.getPenult();// предпоследний по величине элемент
        }
    }