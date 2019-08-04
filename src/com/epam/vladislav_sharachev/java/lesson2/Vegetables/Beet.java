package com.epam.vladislav_sharachev.java.lesson2.Vegetables;

public class Beet extends Vegetable implements Salad {

    public void salad() {
        System.out.println("Добавить свеклу в салат");
    }

    public Beet(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(500);
        this.setCalories(43);
        this.setTitle("Свекла");
    }

    public void refrigerator() {
        System.out.println("Свекла лежит в холодильнике");
    }
    public void soup() {
        System.out.println("Добавить нарезанную свеклу в суп");
    }

}
