package com.epam.vladislav_sharachev.java.lesson7.task1.Vegetables;

import com.epam.vladislav_sharachev.java.lesson7.task1.Product;

public class Potato extends Product  {

    public Potato(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(200);
        this.setCalories(80);
        this.setTitle("Картофель");
    }
@Override
    public void soup() {
        System.out.println("Добавить нарезанный картофель в суп");
    }


}