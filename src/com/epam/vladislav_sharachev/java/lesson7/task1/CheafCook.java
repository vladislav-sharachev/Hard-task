package com.epam.vladislav_sharachev.java.lesson7.task1;

import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.ForStrings;
import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.Init;
import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.Search;
import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.Sum;
import com.epam.vladislav_sharachev.java.lesson7.task1.Spices.PutSpice;
import com.epam.vladislav_sharachev.java.lesson7.task1.Vegetables.Salad;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class CheafCook {
    Product[] foods;

    public CheafCook(Product[] foods) {
        this.foods = foods;
    }

    public  void process(Object object) throws IllegalAccessException {
        Class<?> objectClass = object.getClass();
        Annotation[] annotations;
        String title;
        Field[] fields = objectClass.getFields();
        for (Field f : fields) {
            annotations = f.getAnnotations();
            for (Annotation a : annotations) {
                if (a.annotationType().getSimpleName().equals(ForStrings.class.getSimpleName())) {
                    if(f.get(object) != "title") {
                        System.out.println(String.format("Warning: null value in %s", f.getName()));
                    }
                }
                if (a.annotationType().getSimpleName().equals(Search.class.getSimpleName())) {
                    Search ann = (Search) a;
                    if (f.getInt(object) > ann.searchMax()) {
                        System.out.println(String.format("Warning...", f.getName(), f.getInt(object), ann.searchMax()));
                    } else if (f.getInt(object) < ann.searchMin()) {
                        System.out.println(String.format("Warning...", f.getName(), f.getInt(object), ann.searchMin()));
                    }

                }
            }
        }
        process(objectClass);
    }

    public void go(Object object) throws NoSuchFieldException {
        Class<?> cheafCookClass = Product.class;
        Annotation[] annos = cheafCookClass.getAnnotations();

        Field nameField = cheafCookClass.getDeclaredField("title");
        Annotation[] fieldAnnos = nameField.getAnnotations();

        for (Annotation ann : fieldAnnos) {
            if (ann.annotationType().getSimpleName().equals(ForStrings.class.getSimpleName())) {

            }

            System.out.println(ann.annotationType().getSimpleName());
        }
        for (Annotation ann : annos) {
            if (a.annotationType().getSimpleName().equals(Search.class.getSimpleName())) {
                Search ann = (Search) a;
                if (f.getInt(object) > ann.searchMax()) {
                    System.out.println(String.format("Warning...", f.getName(), f.getInt(object), ann.searchMax()));
                } else if (f.getInt(object) < ann.searchMin()) {
                    System.out.println(String.format("Warning...", f.getName(), f.getInt(object), ann.searchMin()));
                }
            System.out.println(ann.annotationType().getSimpleName());
        }
    }



    @Init
    String shouldAlwaysBeProcessed() {
        return "This always be processed";
    }

    @Init(suppressException = false)
    public void shouldNotBeProcessed() {
        throw new RuntimeException("This should never be processed");
    }

    @Init
    public void getSorting() { //сортировка

        Arrays.sort(foods);
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getCalories() + " ккал - " + foods[i].getTitle());
        }
    }

    public void getMyEat() { //еда в холодильнике
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getTitle());
        }
    }
@Init
    public void getSum() { //сумма каллорий в пище
        @Sum
        int sum = 0;
        for (int i = 0; i < foods.length; ++i) {
            sum = sum + foods[i].getCalories();
        }
        System.out.println("Общая каллорийность продуктов: " + sum + " ккал");
    }

    public void getFind() { //поиск по диапазону по каллорий

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