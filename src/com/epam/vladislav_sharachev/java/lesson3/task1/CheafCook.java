package com.epam.vladislav_sharachev.java.lesson3.task1;

import com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.checked.SearchQueryIsInvalidExcaption;
import com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked.SumIndicatorIsNegativeExcaption;
import com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked.SortingIndicatorIsNegativeExcaption;
import com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked.SortingIndicatorIsZeroExcaption;
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

    public void getSorting() throws SortingIndicatorIsNegativeExcaption, SortingIndicatorIsZeroExcaption { //сортировка
        Arrays.sort(foods);
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getCalories() + " ккал - " + foods[i].getTitle());

            if (foods[i].getCalories() < 0) {
                throw new SortingIndicatorIsNegativeExcaption("Имеется продукт с отрицательным" +
                        " показателем каллорийности");
            } else if (foods[i].getCalories() == 0) {
                throw new SortingIndicatorIsZeroExcaption("Имеется продукт с нулевым" +
                        " показателем каллорийности");
            }
        }
    }


    public void getMyEat() { //еда в холодильнике
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getTitle());
        }
    }

    public void getSum() throws SumIndicatorIsNegativeExcaption { //сумма каллорий в пище
        int sum = 0;
        for (int i = 0; i < foods.length; ++i) {
            if (foods[i].getCalories() < 0) throw new SumIndicatorIsNegativeExcaption("Имеется продукт с отрицательным" +
                    " показателем каллорийности");
            //исключение при обращении к продукту с отрицательными каллориями
            sum = (sum + foods[i].getCalories());
        }
        System.out.println("Общая каллорийность продуктов: " + sum + " ккал");
    }

    public void getFind() throws SearchQueryIsInvalidExcaption { //поиск по диапазону по каллорий
        int searchMin = getSort();
        int searchMax = getSort();
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].getCalories() >= searchMin && foods[i].getCalories() <= searchMax)
                System.out.println(+i + " " + foods[i].getTitle() + " - "
                        + foods[i].getCalories() + " ккал.");
        }
        if (searchMin < 0 || searchMax < 0) // исключение  отрицательного значения
            throw new SearchQueryIsInvalidExcaption("Каллории не могут быть отрицательными");
        if (searchMin > searchMax) //исключение ситкации при которой нижний диапазон больше верхнего
            throw new SearchQueryIsInvalidExcaption("Нижний дипапазон должен быть меньше верхнего");
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
        Scanner scanner = new Scanner(file);
    }

}