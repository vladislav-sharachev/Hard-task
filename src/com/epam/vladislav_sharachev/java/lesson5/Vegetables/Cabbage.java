package com.epam.vladislav_sharachev.java.lesson5.Vegetables;

import com.epam.vladislav_sharachev.java.lesson5.Product;

public class Cabbage extends Product  {

    public Cabbage(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(500);
        this.setCalories(27);
        this.setTitle("Капуста");
    }



    public void soup() {
        System.out.println("Добавить нарезанную капусту в суп");
    }
}
