package com.epam.vladislav_sharachev.java.lesson7.task1; // Влад Шарачев 2 вариант (Шеф-повар)

import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.Search;
import com.epam.vladislav_sharachev.java.lesson7.task1.Excaptions.FieldNotFoundExcaption;
import com.epam.vladislav_sharachev.java.lesson7.task1.Vegetables.*;
import com.epam.vladislav_sharachev.java.lesson7.task1.Spices.*;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Scanner;

public class ToCook {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, FileNotFoundException {

        ToCook app = new ToCook();
        app.startToCookForMe();

    }

    public void startToCookForMe() throws NoSuchFieldException, IllegalAccessException, FileNotFoundException {



        Product[] products = new Product[7];
        products[0] = new Beet(43, "Свекла", 500);
        products[1] = new Cabbage(27, "Капуста", 500);
        products[2] = new Carrot(41, "Морковь", 200);
        products[3] = new Garlic(149, "Чеснок", 20);
        products[4] = new Potato(80, "Картофель", 200);
        products[5] = new Tomato(18, "Помидор", 200);
        products[6] = new Pepper(1, "Перец", 1);






        CheafCook cheaf = new CheafCook(products);      //ссылаемся на класс шеф-повара
        Salad garlicToSalad = new Garlic(149, "Чеснок", 20);    //интерфейс "добавление овощей в салат"
        Salad beetToSalad = new Beet(43, "Свекла", 500);

        PutSpice pepperToPut = new Pepper(0, "00", 1);      //интерфейс "добавление специй"
        PutSpice saltToPut = new Salt(0, "00", 0);


     /*   Class<CheafCook> obj = CheafCook.class;
        if (obj.isAnnotationPresent(Sum.class)) {
            Annotation annotation = obj.getAnnotation(Sum.class);
            Sum custom = (Sum) annotation;
            System.out.println("%nSum :%s");
        }*/

cheaf.final1();
cheaf.final2();

cheaf.final3();


  /*      try {

            cheaf.final3();

        } catch (FieldNotFoundExcaption e) {
            e.printStackTrace();
        }
        finally {

            System.out.println("Еду еще нужно приготовить");

        } */






        while (true) {      //запускаем наш цикл
            cheaf.getQuest();
            int exit = getSearchers();
            if (exit == 0) {  //условие окончания цикла
                break;
            }

            switch (exit) {
                case 1:
                    cheaf.getMyEat();
                //    cheaf.shouldNotBeProcessed();
                 //   cheaf.shouldAlwaysBeProcessed();
                    break;

                case 2:
                    cheaf.outputSaladInfo(garlicToSalad);
                    cheaf.outputSaladInfo(beetToSalad);
                    cheaf.outputPutSpiceInfo(pepperToPut);
                    cheaf.outputPutSpiceInfo(saltToPut);
                    cheaf.saladIsReady();
                    break;
                case 3:
                    cheaf.soupCook();
                    cheaf.outputPutSpiceInfo(pepperToPut);
                    cheaf.outputPutSpiceInfo(saltToPut);
                    cheaf.soupIsReady();
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
                default:
                    System.out.println("Нет такого варианта");
            }
        }
    }

    public Scanner inputScanner = new Scanner(System.in);

    public int getSearchers() {

        System.out.print("");

        int input;

        if (inputScanner.hasNextInt()) {

            input = inputScanner.nextInt();

        } else {

            System.out.println("Введите только числовое значение.");

            inputScanner.next();

            input = getSearchers();

        }

        return input;

    }
}