package com.epam.vladislav_sharachev.java.lesson3.task1.Spices;

import com.epam.vladislav_sharachev.java.lesson3.task1.Product;

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
        System.out.println("Насыпать щепотку перца");
    }

}
