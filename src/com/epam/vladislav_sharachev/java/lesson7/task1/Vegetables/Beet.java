package com.epam.vladislav_sharachev.java.lesson7.task1.Vegetables;

import com.epam.vladislav_sharachev.java.lesson7.task1.Product;

public class Beet extends Product implements Salad {


    public Beet(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(500);
        this.setCalories(43);
        this.setTitle("Свекла");
    }


    public void salad() {
        System.out.println("Добавить свеклу в салат");
    }

    @Override
    public void soup() {
        System.out.println("Добавить нарезанную свеклу в суп");
    }

}
