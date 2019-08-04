package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

public class Cabbage extends Vegetable {

    public Cabbage(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(500);
        this.setCalories(27);
        this.setTitle("Капуста");
    }

    @Override
    public void refrigerator() {
        System.out.println("Капуста лежит в холодильнике");
    }

    public void soup() {
        System.out.println("Добавить нарезанную капусту в суп");
    }
}
