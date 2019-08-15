package com.epam.vladislav_sharachev.java.lesson7.task1.Vegetables;

import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.NonNull;
import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.ProductType;
import com.epam.vladislav_sharachev.java.lesson7.task1.Product;

public class Tomato extends Product {
    @ProductType(weight = 200, calories = 17, title = "Помидор")
    public Tomato(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(200);
        this.setCalories(18);
        this.setTitle("Помидор");
    }

    @Override
    public void soup() {
        System.out.println("Добавить помидор в суп");
    }
}