package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

public class Tomato extends Vegetable {

    public Tomato (int calories, String title, int weight) {
        super(calories, title, weight);
        this.weight = 200;
        this.calories = 18;
    }

    public void refrigerator() {
        System.out.println("Помидор лежит в холодильнике");
    }
    public void soup() {
        System.out.println("Добавить помидор в суп");
    }
}