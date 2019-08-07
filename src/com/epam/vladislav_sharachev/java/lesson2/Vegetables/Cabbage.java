package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

import com.epam.vladislav_sharachev.java.lesson2.Product;

public class Cabbage extends Product implements Fridge {

    public Cabbage(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(500);
        this.setCalories(27);
        this.setTitle("Капуста");
    }

    @Override
    public void fridge() {
        System.out.println("Капуста лежит в холодильнике");
    }

    public void soup() {
        System.out.println("Добавить нарезанную капусту в суп");
    }
}
