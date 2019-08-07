package com.epam.vladislav_sharachev.java.lesson2; // Влад Шарачев 2 вариант (Шеф-повар)

import com.epam.vladislav_sharachev.java.lesson2.Vegetables.*;
import com.epam.vladislav_sharachev.java.lesson2.Spices.*;
import com.epam.vladislav_sharachev.java.lesson2.CheafCook;


import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.Scanner;

public class ToCook {
    public static void main(String[] args) {

        ToCook app = new ToCook();
        app.startToCookForMe();

    }

    static Scanner searchScanner = new Scanner(System.in);

    private static int getSearchers() {

        System.out.print("");

        int input;

        if (searchScanner.hasNextInt()) {

            input = searchScanner.nextInt();

        } else {

            System.out.println("Введите только числовое значение.");

            searchScanner.next();

            input = getSearchers();

        }

        return input;

    }

    public void outputSaladInfo(Salad toSalad) {
        toSalad.salad();
    }


    public void outputPutSpiceInfo(PutSpice toPutSpice) {
        toPutSpice.putSpice();
    }

    public void startToCookForMe() {
        while (true) {
            System.out.println("[1] - что в холодильнике " +
                    "[2] - приготовить салат " +
                    "[3] - приготовить суп " +
                    "[4] - каллорийность продуктов в супе " +
                    "[5] - сортировать овощи для салата по каллорийности " +
                    "[6] - найти по диапазону каллорийности");


            Product[] products = new Product[7];
            products[0] = new Beet(43, "Свекла", 500);
            products[1] = new Cabbage(27, "Капуста", 500);
            products[2] = new Carrot(41, "Морковь", 200);
            products[3] = new Garlic(149, "Чеснок", 20);
            products[4] = new Potato(80, "Картофель", 200);
            products[5] = new Tomato(18, "Помидор", 200);
            products[6] = new Pepper(1, "Перец", 1);


            CheafCook cheaf = new CheafCook(products);

            Salad salad = new Garlic(149, "Чеснок", 20);
            Salad toSalad = new Beet(43, "Свекла", 500);

            PutSpice putSpice = new Pepper(0, "00", 1);
            PutSpice putSpice1 = new Salt(0, "00", 0);


            switch (getSearchers()) {
                case 1:
                    cheaf.getMyEat();
                    break;

                case 2:
                    outputSaladInfo(salad);
                    outputSaladInfo(toSalad);
                    outputPutSpiceInfo(putSpice);
                    outputPutSpiceInfo(putSpice1);
                    System.out.println("Салат готов");
                    break;
                case 3:
                    for (Product product : products) {
                        product.soup();
                    }
                    outputPutSpiceInfo(putSpice);
                    outputPutSpiceInfo(putSpice1);
                    System.out.println("Суп готов");
                    break;
                case 4:
                    cheaf.getSum();
                    break;
                case 5:
                    cheaf.getSorting();
                    break;
                case 6:
                    cheaf.getFind();
                    break;
            }
        }
    }
}