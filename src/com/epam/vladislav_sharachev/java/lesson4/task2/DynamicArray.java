package com.epam.vladislav_sharachev.java.lesson4.task2;

import java.util.ArrayList;
import java.lang.Integer;

public class DynamicArray<E> {


    public static void main(String[] args) {

        ArrayList<Integer> myMillion = new ArrayList(); //создаем массив
        ArrayMethods letsGo = new ArrayMethods(myMillion); //ссылка на конструктор с методами

        letsGo.Add(); // добавить числа в массив
        letsGo.Mix(); //перемешать и показать что числа перемешаны (первые 10 элементов)
        letsGo.Unique(); //создание 2-го массива для сравнения с 1-м (проверка уникальности)
        letsGo.Min(); //вывести на экран минимальный элемент массива
        letsGo.Parity(); //удалить все нечетные числа
        letsGo.Penult();// отсортировать массив и показать предпоследний по величине элемент
    }
}