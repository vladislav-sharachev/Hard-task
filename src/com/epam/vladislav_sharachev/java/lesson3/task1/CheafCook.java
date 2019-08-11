package com.epam.vladislav_sharachev.java.lesson3.task1;

import com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.checked.MySearchExcaption;
import com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.checked.MySumExcaption;
import com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked.MySortMinusExcaption;
import com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked.MySortZeroExcaption;
import com.epam.vladislav_sharachev.java.lesson3.task1.Spices.PutSpice;
import com.epam.vladislav_sharachev.java.lesson3.task1.Vegetables.Salad;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CheafCook {
    Product[] foods;

    public CheafCook(Product[] foods) {
        this.foods = foods;
    }

    public void getSorting() { //сортировка
        Arrays.sort(foods);
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getCalories() + " ккал - " + foods[i].getTitle());

            try { //исключение при обращении к продукту с отрицательными каллориями
                if (foods[i].getCalories() < 0) {
                    throw new MySortMinusExcaption("Имеется продукт с отрицательным" +
                            " показателем каллорийности");
                } else if (foods[i].getCalories() == 0) {
                    throw new MySortZeroExcaption("Имеется продукт с нулевым" +
                            " показателем каллорийности");
                }
            } catch (MySortMinusExcaption | MySortZeroExcaption e) {
                e.printStackTrace();
            }
        }
    }

    public void getMyEat() { //еда в холодильнике
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getTitle());
        }
    }

    public void getSum() { //сумма каллорий в пище
        int sum = 0;
        for (int i = 0; i < foods.length; ++i) {
            try {
                if (foods[i].getCalories() < 0) throw new MySumExcaption("Имеется продукт с отрицательным" +
                        " показателем каллорийности");
                //исключение при обращении к продукту с отрицательными каллориями
            } catch (MySumExcaption e) {
                e.printStackTrace();

            }
            sum = (sum + foods[i].getCalories());
        }
        System.out.println("Общая каллорийность продуктов: " + sum + " ккал");
    }

    public void getFind() { //поиск по диапазону по каллорий
        int searchMin = getSort();
        int searchMax = getSort();
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].getCalories() >= searchMin && foods[i].getCalories() <= searchMax)
                System.out.println(+i + " " + foods[i].getTitle() + " - "
                        + foods[i].getCalories() + " ккал.");
        }
        try {
            if (searchMin < 0 || searchMax < 0) // исключение  отрицательного значения
                throw new MySearchExcaption("Каллории не могут быть отрицательными");

        } catch (MySearchExcaption e) {
            e.printStackTrace();
        }
        try {
            if (searchMin > searchMax) //исключение ситкации при которой нижний диапазон больше верхнего
                throw new MySearchExcaption("Нижний дипапазон должен быть меньше верхнего");
        } catch (MySearchExcaption e) {
            e.printStackTrace();
        } finally {
            System.out.println("Хотите продолжить?");
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
                "[0] - закрыть меню");
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

    public void getFile() throws FileNotFoundException { //поиск файла рецепта + исключение
        File file = new File("Recepts");
        try {
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("ВАЖНО!!! Файл с рецептами не найден");
        } finally {
            System.out.println("Еду еще нужно приготовить");
        }
    }
}