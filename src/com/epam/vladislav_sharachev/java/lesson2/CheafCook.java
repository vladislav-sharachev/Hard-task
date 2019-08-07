package com.epam.vladislav_sharachev.java.lesson2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class CheafCook {
    Product[] foods;

    public CheafCook(Product[] foods) {
        this.foods = foods;
    }

    public void getSorting() {

        Arrays.sort(foods);
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getCalories() + " ккал - " + foods[i].getTitle());
        }
    }

    public void getMyEat() {
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getTitle());
        }
    }

    public void getMyCook() {
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getTitle());
        }
        System.out.println("Что вы хотите выбрать?");

        String myChoice1 = new String();
        for (int i = 0; i < foods.length; i++) {
            if (myChoice1 == foods[0].getTitle());

        }

    }


    public void getSum() {

        int sum = 0;
        for (int i = 0; i < foods.length; ++i) {
            sum = sum + foods[i].calories;
        }
        System.out.println("Общая каллорийность продуктов: " + sum + " ккал");
    }


    public void getFind() {

        while (true) {

            int searchMin = getSort();

            int searchMax = getSort();

            for (int i = 0; i < foods.length; i++) {

                if (foods[i].getCalories() >= searchMin && foods[i].getCalories() <= searchMax)

                    System.out.println(+i + " " + foods[i].getTitle() + " - "

                            + foods[i].getCalories() + " ккал.");

            }

            if (searchMin > searchMax) {

                System.out.println("Первое число должно быть меньше второго");

            } else break;

        }

    }

    Scanner searchScanner = new Scanner(System.in);

    public int getSort() {

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


}

