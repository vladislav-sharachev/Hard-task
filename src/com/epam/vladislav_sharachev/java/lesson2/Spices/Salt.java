package com.epam.vladislav_sharachev.java.lesson2.Spices;

public class Salt extends Spice {
    public Salt(String title, int weight) {
        super(title, weight);
        this.weight = 2;
        this.title = "Sea Salt";
    }
    public void putSpice() {
        System.out.println("Насыпать щепотку соли");


    }

}
