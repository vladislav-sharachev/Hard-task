package com.epam.vladislav_sharachev.java.lesson2.Spices;

import com.epam.vladislav_sharachev.java.lesson2.Product;

public class Salt extends Product implements PutSpice {
    public Salt(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setCalories(0);
        this.setTitle("Соль");
    }

    @Override
    public void soup() {

    }

    public void putSpice() {
        System.out.println("Насыпать щепотку соли");
    }

}
