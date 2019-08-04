package com.epam.vladislav_sharachev.java.lesson2.Spices;

public class Pepper extends Spice { //приемственность
    public Pepper(String spiceTitle, int energy) {
        super(spiceTitle, energy);
        this.setCalories(1);
        this.setTitle("Перец");
    }

    public void putSpice() {
        System.out.println("Насыпать щепотку перца");
    }

    public void setTitle(String sTitle) { // this часто используется в сеттерах
        this.title = sTitle;
    }

}
