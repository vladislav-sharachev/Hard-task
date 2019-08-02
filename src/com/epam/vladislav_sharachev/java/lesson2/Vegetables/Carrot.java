package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

public class Carrot extends Vegetable {

    public void soup() {
        System.out.println("Добавить нарезанную морковь в суп");
    }

    public Carrot (int calories, String title, int weight) {
        super(calories, title, weight);
        this.weight = 200;
        this.calories = 41;
    }

    public void refrigerator() {
        System.out.println("Морковь лежит в холодильнике");
    }
}