package com.epam.vladislav_sharachev.java.lesson7.task1;

import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.Search;
import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.checkTitleIsOk;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class Product implements Comparable { //использование интерфеса Comparable
    protected int weight; // инкапсуляция
    @Search(min = 0, max = 250)
    protected int calories;
    @checkTitleIsOk(info = "title")
    private String title0;


    public Product(int calories, String title0, int weight) {
        this.calories = calories; //ключевое слово this
        this.title0 = title0;
        this.weight = weight;
    }


    public abstract void soup();


    public void setTitle(String itemTitle) { // this ключевое слово для для title
        this.title0 = itemTitle;
    }

    public String getTitle() {
        return title0;
    }

    public void setCalories(int itemCalories) { // this ключевое слово для calories
        this.calories = itemCalories;
    }

    public int getCalories() {
        return calories;
    }

    public void setWeight(int itemWeight) {
        this.weight = itemWeight;
    }

    public int compareTo(Object obj) { //использование интерфеса для реализации сортировки
        Product mySort = (Product) obj;
        if (this.calories < mySort.calories) {
            return -1;
        } else if (this.calories > mySort.calories) {
            return 1;
        }
        return 0;
    }

    public void vfw() {
        Class  <Product> myProduct = Product.class;
        try {
            for (
                    Field method : Product.class
                    .getClassLoader()
                    .loadClass(("com.epam.vladislav_sharachev.java.lesson7.task1.Product"))
                    .getDeclaredFields())
                if (method.isAnnotationPresent(Search.class)) {
                    try {
                        Annotation[] annotations = Product.class.getDeclaredField("calories").getAnnotations();

                        for (Annotation annot : annotations) {
                            if (annot instanceof Search) {
                                int min = Product.class.getDeclaredField("calories").getAnnotation(Search.class).min();
                                int max = Product.class.getDeclaredField("calories").getAnnotation(Search.class).max();
                                if(((Search) annot).max() < getCalories() || ((Search) annot).min() > getCalories()) {
                                    System.out.println("WARNING! значение каллорий выходит за диапазон от 0 до 250");
                                } else {
                                    System.out.println("значение нормальное");
                                }
                            }
                        }

                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
