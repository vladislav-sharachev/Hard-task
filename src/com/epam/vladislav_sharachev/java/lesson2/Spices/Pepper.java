package com.epam.vladislav_sharachev.java.lesson2.Spices;

import com.epam.vladislav_sharachev.java.lesson2.Product;

public class Pepper extends Product implements PutSpice { //приемственность
    public Pepper(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setCalories(1);
        this.setTitle("Перец");
    }

    @Override
    public void soup() {

    }

    public void putSpice() {
        System.out.println("Чеснок лежит в холодильнике");
    }

    public void setTitle(String sTitle) { // this часто используется в сеттерах
        this.title = sTitle;
    }


}
