package com.epam.vladislav_sharachev.java.unit_framework.testNG;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityTest { //запуск тестов с учетом приоритета


    private Calculator calculator = new Calculator();
    private double firstValue = 10;
    private double secondValue = 5;

    @Test(description = "Sub", priority = 3)
    public void checkSub() {
        Assert.assertEquals(calculator.sub(firstValue, secondValue),
                firstValue - secondValue);
    }

    @Test(description = "Sum", priority = 1)
    public void checkSum() {
        Assert.assertEquals(calculator.sum(firstValue, secondValue),
                firstValue + secondValue);
    }

    @Test(description = "Div", priority = 1)
    public void checkDiv() {
        Assert.assertEquals(calculator.div(firstValue, secondValue),
                firstValue / secondValue);
    }

    @Test(description = "Mult", priority = 2)
    public void checkMult() {
        Assert.assertEquals(calculator.mult(firstValue, secondValue),
                firstValue * secondValue);
    }
}