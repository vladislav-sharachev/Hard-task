package com.epam.vladislav_sharachev.java.lesson2.Spices;

public class Salt extends Spice {
    public Salt(String title, int energy) {
        super(title, energy);
        this.setCalories(0);
        this.setTitle("Соль");
    }
    public void putSpice() {
        System.out.println("Насыпать щепотку соли");
    }

}
