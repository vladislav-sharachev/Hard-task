package com.epam.vladislav_sharachev.java.lesson7.task1;

import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.RangeOfValues;
import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.checkTitleIsOk;

public abstract class Product implements Comparable { //использование интерфеса Comparable
    protected int weight; // инкапсуляция
    @RangeOfValues(min = 0, max = 250)
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
}
