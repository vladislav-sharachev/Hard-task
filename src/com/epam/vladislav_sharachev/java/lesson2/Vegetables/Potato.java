package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

import com.epam.vladislav_sharachev.java.lesson2.Product;

public class Potato extends Product implements Fridge {

    public Potato(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(200);
        this.setCalories(80);
        this.setTitle("Картофель");
    }

    public void soup() {
        System.out.println("Добавить нарезанный картофель в суп");
    }

    @Override
    public void fridge() {
        System.out.println("Картофель лежит в холодильнике");

    }
}