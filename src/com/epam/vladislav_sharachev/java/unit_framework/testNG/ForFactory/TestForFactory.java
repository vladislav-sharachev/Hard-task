package com.epam.vladislav_sharachev.java.unit_framework.testNG.ForFactory;

import org.testng.annotations.Test;

public class TestForFactory {


    private String text = "Value";
    private int value = 5;

    public TestForFactory(String text, int value) {
        this.text = text;
        this.value = value;
    }

    @Test
    public void sett() {
        if (value > 0) {
            System.out.println("Value > 0 " + text);
        } else
            System.out.println("Value <= 0  " + text);
    }
}
