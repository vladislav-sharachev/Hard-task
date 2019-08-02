package com.epam.vladislav_sharachev.java.lesson2;

import com.epam.vladislav_sharachev.java.lesson2.Vegetables.*;
import com.epam.vladislav_sharachev.java.lesson2.Spices.*;

import java.util.*;
import java.util.Scanner;

public class Main {

    private static int getInt() {
        return 0;
    }
    public static void outputInfo(Salad toSalad) {
        toSalad.salad();
    }
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Vegetable[] vegetables = new Vegetable[6];
        vegetables[0] = new Beet(43, "Свекла", 500);
        vegetables[1] = new Cabbage(27, "Капуста", 500);
        vegetables[2] = new Carrot(41, "Морковь", 200);
        vegetables[3] = new Garlic(149, "Чеснок", 20);
        vegetables[4] = new Potato(80, "Картофель", 200);
        vegetables[5] = new Tomato(18, "Помидор", 200);

        Spice[] spices = new Spice[2];
        spices[0] = new Pepper("123", 2);
        spices[1] = new Salt("123", 1);

        Vegetable beet = new Beet(43, "Свекла", 500);
        Vegetable cabbage = new Cabbage(27, "Капуста", 500);
        Vegetable carrot = new Carrot(41, "Морковь", 200);
        Vegetable garlic = new Garlic(149, "Чеснок", 20);
        Vegetable potato = new Potato(80, "Картофель", 200);
        Vegetable tomato = new Tomato(18, "Помидор", 200);

        Salad salad1 = new Garlic(149, "Чеснок", 20);
        Salad salad2 = new Beet(43, "Свекла", 500);

        while (true) {
            System.out.println("[1] - посмотреть список продуктов в холодильнике; " +
                    "[2] - приготовить обед; " +
                    "[3] - общая каллорийность продуктов в супе; " +
                    "[4] - сортировать овощи для салата по каллорийности; " +
                    "[5] - найти продукт в борще по диапазону.");

            String command = scanner.nextLine();
            if ("1".equals(command)) {
                for (Vegetable vegetable: vegetables) {
                    vegetable.refrigerator();
                }
            } else if ("2".equals(command)) {
                System.out.println("Приготовить обед");
                while (true) {
                    System.out.println("[1] - приготовить салат; " +
                            "[2] - приготовить борщ; "
                            + "[Любая клавиша] - вернутся назад.");
                    String command1 = scanner.nextLine();
                    if ("1".equals(command1)) {
                        outputInfo(salad1);
                        outputInfo(salad2);
                        for (Spice spice: spices) {
                            spice.putSpice();
                        }
                        System.out.println("Салат готов");
                    } else if ("2".equals(command1)) {

                        for (Vegetable vegetable: vegetables) {
                            vegetable.soup();
                        }
                        for (Spice spice: spices) {
                            spice.putSpice();
                        }
                        System.out.println("Суп готов");
                    } else System.out.println("Возвращение".equals(command));
                    break;
                }
            } else if ("3".equals(command)) {
                System.out.println("Общая каллорийность продуктов: " + (beet.calories + cabbage.calories
                        + carrot.calories + garlic.calories + potato.calories + tomato.calories + beet.calories)
                        + " ккал");
            } else if ("4".equals(command)) {
                while (true) {
                    System.out.println("Калорийность на 100 г продукта:");
                    Arrays.sort(vegetables);
                    for (int i = 0; i < vegetables.length; i++) {
                        System.out.println(vegetables[i].calories + " ккал - " + vegetables[i].title);
                    }
                    break;
                }
            } else if ("5".equals(command)) {
                while (true) {
                    System.out.println("Введите значение");
                    int input;
                    if (scanner.hasNextInt()) {
                        input = scanner.nextInt();
                    } else {
                        System.out.println("Введите только числовое значение.");
                        input = getInt();
                    }
                    for (int i = 0; i < vegetables.length; i++) {
                        if (vegetables[i].calories <= input)
                            System.out.println(+i + " " + vegetables[i].title + " - " + vegetables[i].calories
                                    + " ккал.");
                    }
                }
            } else System.out.print("");
        }
    }
}