package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

public class Potato extends Vegetable {

    public Potato (int calories, String title, int weight) {
        super(calories, title, weight);
        this.weight = 200;
        this.calories = 80;
    }

    public void refrigerator() {
        System.out.println("Картофель лежит в холодильнике");
    }
    public void soup() {
        System.out.println("Добавить нарезанный картофель в суп");
    }
}