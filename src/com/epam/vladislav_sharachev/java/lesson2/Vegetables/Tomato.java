package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

import com.epam.vladislav_sharachev.java.lesson2.Product;

public class Tomato extends Product implements Fridge {

    public Tomato(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(200);
        this.setCalories(18);
        this.setTitle("Помидор");
    }

    public void fridge() {
        System.out.println("Помидор лежит в холодильнике");
    }

    public void soup() {
        System.out.println("Добавить помидор в суп");
    }
}