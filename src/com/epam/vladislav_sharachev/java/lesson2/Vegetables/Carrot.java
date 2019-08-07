package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

import com.epam.vladislav_sharachev.java.lesson2.Product;

public class Carrot extends Product implements Fridge {

    public void soup() {
        System.out.println("Добавить нарезанную морковь в суп");
    }

    public Carrot(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(200);
        this.setCalories(41);
        this.setTitle("Морковь");
    }

    public void fridge() {
        System.out.println("Морковь лежит в холодильнике");
    }
}