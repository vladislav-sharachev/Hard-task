package com.epam.vladislav_sharachev.java.lesson4.task2;

import java.util.ArrayList;
import java.lang.Integer;

public class DynamicArray<E> {


    public static void main(String[] args) {

        ArrayList<Integer> newMillion = new ArrayList(); //создаем массив
        ArrayMethods changeMillion = new ArrayMethods(newMillion); //ссылка на конструктор с методами

        changeMillion.Add(); // добавить числа в массив
        changeMillion.Mix(); //перемешать и показать что числа перемешаны (первые 10 элементов)
        changeMillion.Unique(); //создание 2-го массива для сравнения с 1-м (проверка уникальности)
        changeMillion.Min(); //вывести на экран минимальный элемент массива
        changeMillion.Parity(); //удалить все нечетные числа
        changeMillion.Penult();// отсортировать массив и показать предпоследний по величине элемент
    }
}