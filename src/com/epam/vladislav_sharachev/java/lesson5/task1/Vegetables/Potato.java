package com.epam.vladislav_sharachev.java.lesson5.task1.Vegetables;

import com.epam.vladislav_sharachev.java.lesson5.task1.Product;

import java.io.Serializable;

public class Potato extends Product implements Serializable {

    public Potato(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(200);
        this.setCalories(80);
        this.setTitle("Картофель");
    }

    public void soup() {
        System.out.println("Добавить нарезанный картофель в суп");
    }

    public String toString() {
        return setTitle();
    }

    public String setTitle() {
        return null;
    }

}