package com.epam.vladislav_sharachev.java.unit_framework.testNG;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest { //датапровайдер

    private Calculator calc = new Calculator();
    private double delta = 0.01;

    @Test(dataProvider = "DoubleValuesForTest") // //указываем что датапровайдер имеет данное имя
    public void CalcSum(double firstNumber, double secondNumber) {
        System.out.println("CalcSum");
        double actualResult = calc.sum(firstNumber, secondNumber);
        Assert.assertEquals(actualResult, (double) firstNumber + secondNumber,
                "Ошибка во время сложения 10 и 1");
        System.out.println(actualResult);
    }

    @DataProvider(name = "DoubleValuesForTest") //указываем что это датапровайдер
    public Object[][] getValues() {
        return new Object[][]{
                new Object[]{10, 5},
                new Object[]{-20, 10},
                new Object[]{17, -25}
        };
    }
}