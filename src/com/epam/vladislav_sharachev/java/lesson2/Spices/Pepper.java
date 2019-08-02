package com.epam.vladislav_sharachev.java.lesson2.Spices;

public class Pepper extends Spice {
    public Pepper(String title, int weight) {
        super(title, weight);
        this.weight = 1;
        this.title = "Black Pepper";
    }

    public void putSpice() {
        System.out.println("Насыпать щепотку перца");
    }

    public void setTitle(String title) { // this часто используется в сеттерах
        this.title = title;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getTitle() {
        return title;
    }

    public int getWeight() {
        return weight;
    }

    public void getInfo() {
        System.out.println(title + ", " + weight);
    }
}
