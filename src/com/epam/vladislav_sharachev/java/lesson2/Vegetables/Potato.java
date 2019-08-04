package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

public class Potato extends Vegetable {

    public Potato (int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(200);
        this.setCalories(80);
        this.setTitle("Картофель");
    }

    public void refrigerator() {
        System.out.println("Картофель лежит в холодильнике");
    }

    public void soup() {
        System.out.println("Добавить нарезанный картофель в суп");
    }
}