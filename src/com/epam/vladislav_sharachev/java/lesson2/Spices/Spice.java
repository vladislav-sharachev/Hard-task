package com.epam.vladislav_sharachev.java.lesson2.Spices;

public abstract class Spice {
    protected String title; //инкапсуляция
    protected int calories;

    public Spice(String title, int calories) {
        this.title = title;
        this.calories = calories;
    }

    public abstract void putSpice(); //полиморфизм

    public void setTitle(String spiceTitle) { // this часто используется в сеттерах
        this.title = spiceTitle;
    }


    public void setCalories(int energy) {
        this.calories = energy;
    }

    public int getCalories() {
        return calories;
    }

}
