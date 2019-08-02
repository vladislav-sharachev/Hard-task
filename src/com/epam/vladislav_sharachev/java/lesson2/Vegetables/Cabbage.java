package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

public class Cabbage extends Vegetable {

    public Cabbage(int calories, String title, int weight) {
        super(calories, title, weight);
        this.weight = 500;
        this.calories = 27;
    }

    @Override
    public void refrigerator() {
        System.out.println("Морковь лежит в холодильнике");
    }

    public void soup() {
        System.out.println("Добавить нарезанную капусту в суп");
    }
}
