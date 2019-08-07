package com.epam.vladislav_sharachev.java.lesson2;

public abstract class Product implements Comparable { //использование интерфеса Comparable
    protected int weight; // инкапсуляция
    private int calories;
    private String title;


    public Product(int calories, String title, int weight) {
        this.calories = calories; //ключевое слово this
        this.title = title;
        this.weight = weight;
    }


    public abstract void soup();


    public void setTitle(String itemTitle) { // this часто используется в сеттерах
        this.title = itemTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setCalories(int itemCalories) { // this часто используется в сеттерах
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
