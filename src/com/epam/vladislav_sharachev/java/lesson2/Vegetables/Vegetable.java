package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

public abstract class Vegetable implements Comparable {
    protected int weight;
    public int calories;
    public String title;

    public Vegetable(int calories, String title, int weight) {
        this.calories = calories;
        this.title = title;
        this.weight = weight;
    }

    public abstract void refrigerator();

    public abstract void soup();


    public void setTitle(String title) { // this часто используется в сеттерах
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int compareTo(Object obj) {
        Vegetable tmp = (Vegetable) obj;
        if (this.calories < tmp.calories) {
            return -1;
        } else if (this.calories > tmp.calories) {
            return 1;
        }
        return 0;
    }
}
