package com.epam.vladislav_sharachev.java.lesson3.task1;

import com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.cheked.MinusItem;
import com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked.MySearchExcaption;
import com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked.MySortExcaption;
import com.epam.vladislav_sharachev.java.lesson3.task1.Spices.PutSpice;
import com.epam.vladislav_sharachev.java.lesson3.task1.Vegetables.Salad;

import java.io.FileNotFoundException;

import com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked.MyReadExcaption;
import com.sun.org.apache.xpath.internal.operations.Minus;

import javax.crypto.spec.PSource;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class CheafCook {
    Product[] foods;

    public CheafCook(Product[] foods) {
        this.foods = foods;
    }


    public void getSorting() throws MySortExcaption { //сортировка

        Arrays.sort(foods);
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getCalories() + " ккал - " + foods[i].getTitle());
            if (foods[i].getCalories() < 0) throw new MySortExcaption("Имеется продукт с отрицательным" +
                    " показателем каллорийности");
            try {
            } catch (Exception e) {

            } finally {
            }


        }
    }

    public void getMyEat() { //еда в холодильнике
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getTitle());
        }
    }

    public void getSum() throws MySortExcaption, MinusItem { //сумма каллорий в пище

        int sum = 0;
        for (int i = 0; i < foods.length; ++i) {
            if (foods[i].getCalories() < 0) throw new MySortExcaption("Имеется продукт с отрицательным" +
                    " показателем каллорийности");
            try {
            } catch (Exception e) {

            } finally {
            }

            sum = sum + foods[i].getCalories();

        }

        System.out.println("Общая каллорийность продуктов: " + sum + " ккал");
    }


    public void getFind() throws MySearchExcaption { //поиск по диапазону по каллорий


        int searchMin = getSort();

        int searchMax = getSort();

        for (int i = 0; i < foods.length; i++) {

            if (foods[i].getCalories() >= searchMin && foods[i].getCalories() <= searchMax)

                System.out.println(+i + " " + foods[i].getTitle() + " - "

                        + foods[i].getCalories() + " ккал.");

        }

        if (searchMin < 0 || searchMax < 0)
            throw new MySearchExcaption("Каллории не могут быть отрицательными");
        try {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        if (searchMin > searchMax)
            throw new MySearchExcaption("Нижний дипапазон должен быть меньше верхнего");
        try {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Поиск окончен. Хотите завершить работу программы?");
        }


    }


    Scanner searchScanner = new Scanner(System.in);

    public int getSort() { //ввод для поиска по диапазону

        System.out.println("Введите диапазон");

        int sort;

        if (searchScanner.hasNextInt()) {

            sort = searchScanner.nextInt();

        } else {

            System.out.println("Введите только числовое значение.");

            searchScanner.next();

            sort = getSort();

        }

        return sort;

    }


    public void getQuest() { //меню цикла
        System.out.println("[1] - что в холодильнике " +
                "[2] - приготовить салат " +
                "[3] - приготовить суп " +
                "[4] - каллорийность продуктов в супе " +
                "[5] - сортировать овощи для салата по каллорийности " +
                "[6] - найти по диапазону каллорийности " +
                "[0] - выйти из игры");
    }

    public void outputSaladInfo(Salad toSalad) { //добавить овощи в салат
        toSalad.salad();
    }

    public void outputPutSpiceInfo(PutSpice toPutSpice) { //добавить специи в суп/салат

        toPutSpice.putSpice();
    }

    public void soupIsReady() { //сообщение о готовности
        System.out.println("Суп готов");
    }

    public void saladIsReady() { //сообщение о готовности
        System.out.println("Салат готов");
    }

    public void soupCook() { // добавить овощи в суп
        for (Product product : foods) {
            product.soup();
        }

    }


}