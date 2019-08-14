package com.epam.vladislav_sharachev.java.lesson5.task1.Vegetables;

import com.epam.vladislav_sharachev.java.lesson5.task1.Product;

public class Carrot extends Product {

    public void soup() {
        System.out.println("Добавить нарезанную морковь в суп");
    }

    public Carrot(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(200);
        this.setCalories(41);
        this.setTitle("Морковь");
    }


}