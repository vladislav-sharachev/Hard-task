package com.epam.vladislav_sharachev.java.lesson3.task1.Vegetables;

import com.epam.vladislav_sharachev.java.lesson3.task1.Product;

public class Tomato extends Product {

    public Tomato(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(200);
        this.setCalories(-1);
        this.setTitle("Помидор");

    }



    public void soup() {
        System.out.println("Добавить помидор в суп");
    }
}