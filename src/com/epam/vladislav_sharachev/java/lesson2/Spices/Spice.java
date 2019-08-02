package com.epam.vladislav_sharachev.java.lesson2.Spices;

public abstract class Spice {
    public String title;
    public int weight;

    public Spice(String title, int weight) {
        this.title = title;
        this.weight = weight;
    }

    public void sprinkle() { //насыпать специю
        System.out.println("Насыпать щепотку специй ");
    }

    public abstract void putSpice(); //насыпать выбранную специю

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
