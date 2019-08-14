package com.epam.vladislav_sharachev.java.lesson5.Vegetables;

import com.epam.vladislav_sharachev.java.lesson5.Product;

import java.io.Serializable;

public class Tomato extends Product implements Serializable {

    public Tomato(int calories, String title, int weight) {
        super(calories, title, weight);
        this.setWeight(200);
        this.setCalories(18);
        this.setTitle("Помидор");
    }


    public void soup() {
        System.out.println("Добавить помидор в суп");
    }

    public String toString() {
        return setTitle();
    }

    public String setTitle() {
        return null;
    }

    public void setTitle(String itemTitle) { // this ключевое слово для для title
        this.title = itemTitle;
    }

    public String getTitle() {
        return title;
    }

}
