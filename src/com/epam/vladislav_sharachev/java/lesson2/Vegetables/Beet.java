package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

import com.epam.vladislav_sharachev.java.lesson2.Product;

public class Beet extends Product implements Salad, Fridge {


    public Beet(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(500);
        this.setCalories(43);
        this.setTitle("Свекла");
    }

    public void fridge() {
        System.out.println("Свекла лежит в холодильнике");
    }

    public void salad() {
        System.out.println("Добавить свеклу в салат");
    }

    public void soup() {
        System.out.println("Добавить нарезанную свеклу в суп");
    }

}
