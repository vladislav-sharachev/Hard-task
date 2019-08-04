package com.epam.vladislav_sharachev.java.lesson2; // Влад Шарачев 3 вариант (Шеф-повар)

import com.epam.vladislav_sharachev.java.lesson2.Vegetables.*;
import com.epam.vladislav_sharachev.java.lesson2.Spices.*;

import java.util.*;
import java.util.Scanner;

public class Main {

    static Scanner searchScanner = new Scanner(System.in); //ввод значений диапазона (getSearch)

    private static int getSearch() {

        System.out.println("Введите диапазон:");

        int search;

        if(searchScanner.hasNextInt()){

            search = searchScanner.nextInt();

        } else {

            System.out.println("Введите только числовое значение.");

            searchScanner.next();

            search = getSearch();

        }

        return search;

    }
    public static void outputSaladInfo(Salad toSalad) {
        toSalad.salad();
    }
    static Scanner choiceScanner = new Scanner(System.in);
    public static void main(String[] args) {

        Vegetable[] vegetables = new Vegetable[6];
        for (int i = 0; i<vegetables.length; i++) {
            vegetables[0] = new Beet(43, "Свекла", 500);
            vegetables[1] = new Cabbage(27, "Капуста", 500);
            vegetables[2] = new Carrot(41, "Морковь", 200);
            vegetables[3] = new Garlic(149, "Чеснок", 20);
            vegetables[4] = new Potato(80, "Картофель", 200);
            vegetables[5] = new Tomato(18, "Помидор", 200);
        }
        Spice[] spices = new Spice[2];
        spices[0] = new Pepper("Перец", 0);
        spices[1] = new Salt("Соль", 0);

        Salad salad = new Garlic(149, "Чеснок", 20);
        Salad toSalad = new Beet(43, "Свекла", 500);

        while (true) {
            System.out.println("[1] - что есть в холодильнике; " +
                    "[2] - приготовить обед; " +
                    "[3] - каллорийность продуктов в супе; " +
                    "[4] - сортировать овощи для салата по каллорийности; " +
                    "[5] - найти продукт в борще по диапазону каллорийности.");

            String myChoice = choiceScanner.nextLine(); //ввод значений для выбора варианта
            if ("1".equals(myChoice)) {
                for (Vegetable vegetable: vegetables) {
                    vegetable.refrigerator();
                }
            } else if ("2".equals(myChoice)) {
                System.out.println("Что будем готовить?");
                while (true) {
                    System.out.println("[1] - приготовить салат; " +
                            "[2] - приготовить борщ; "
                            + "[Любая клавиша] - вернутся назад.");
                    String myNewChoice = choiceScanner.nextLine();
                    if ("1".equals(myNewChoice)) {
                        outputSaladInfo(salad);
                        outputSaladInfo(toSalad);
                        for (Spice spice: spices) {
                            spice.putSpice(); //полиморфный вызов метода
                        }
                        System.out.println("Салат готов");
                    } else if ("2".equals(myNewChoice)) {

                        for (Vegetable vegetable: vegetables) {
                            vegetable.soup();
                        }
                        for (Spice spice: spices) {
                            spice.putSpice();
                        }
                        System.out.println("Суп готов");
                    } else System.out.println("Возвращение".equals(myChoice));
                    break;
                }
            } else if ("3".equals(myChoice)) {
                System.out.println("Общая каллорийность продуктов: " + (vegetables[0].getCalories()
                        + vegetables[1].getCalories() + vegetables[2].getCalories() + vegetables[3].getCalories()
                        + vegetables[4].getCalories() + vegetables[5].getCalories() + spices[0].getCalories()
                + spices[1].getCalories()) + " ккал");
            } else if ("4".equals(myChoice)) {
                while (true) {
                    System.out.println("Калорийность на 100 г продукта:");
                    Arrays.sort(vegetables); //сортировка
                    for (int i = 0; i < vegetables.length; i++) {
                        System.out.println(vegetables[i].getCalories() + " ккал - " + vegetables[i].getTitle());
                    }
                    break;
                }
            } else if ("5".equals(myChoice)) {
                while (true) {

                    int searchMin = getSearch();
                    int searchMax = getSearch();


                    for (int i = 0; i < vegetables.length; i++) {
                        if (vegetables[i].getCalories() >= searchMin && vegetables[i].getCalories() <= searchMax)
                            System.out.println(+i + " " + vegetables[i].getTitle() + " - "
                                    + vegetables[i].getCalories() + " ккал.");

                }
                    if (searchMin > searchMax) {
                        System.out.println("Первое число должно быть меньше второго");
                } else break;
                }
            } else System.out.print("");
        }
    }
}