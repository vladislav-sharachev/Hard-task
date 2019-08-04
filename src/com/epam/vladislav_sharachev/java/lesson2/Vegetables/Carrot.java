package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

public class Carrot extends Vegetable {

    public void soup() {
        System.out.println("Добавить нарезанную морковь в суп");
    }

    public Carrot (int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(200);
        this.setCalories(41);
        this.setTitle("Морковь");
    }

    public void refrigerator() {
        System.out.println("Морковь лежит в холодильнике");
    }
}