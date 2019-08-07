package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

import com.epam.vladislav_sharachev.java.lesson2.Product;

public class Garlic extends Product implements Salad, Fridge {

    public Garlic(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(20);
        this.setCalories(149);
        this.setTitle("Чеснок");
    }


    public void soup() {
        System.out.println("Добавить нарезанный чеснок в суп");
    }

    public void fridge() {
        System.out.println("Чеснок лежит в холодильнике");
    }

    public void salad() {
        System.out.println("Добавить чеснок в салат");
    }
}

