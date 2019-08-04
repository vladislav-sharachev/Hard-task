package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

public abstract class Vegetable implements Comparable { //использование интерфеса Comparable
    protected int weight; // инкапсуляция
    protected int calories;
    protected String title;


    public Vegetable(int calories, String title, int weight) {
        this.calories = calories; //ключевое слово this
        this.title = title;
        this.weight = weight;
    }


    public abstract void refrigerator();

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

    public int compareTo(Object obj) { //использование интерфеса
        Vegetable tmp = (Vegetable) obj;
        if (this.calories < tmp.calories) {
            return -1;
        } else if (this.calories > tmp.calories) {
            return 1;
        }
        return 0;
    }
}
