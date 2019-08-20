package com.epam.vladislav_sharachev.java.unit_framework.JUnit.testsDemo;

import com.epam.tat.module4.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class MultTest { //умножение

    Calculator calc = new Calculator();

    @Test
    public void multByOneTest() {
        double result = calc.mult(3, 1);
        Assert.assertTrue("Операция умножения 3 на 1 не верная. Актуальный результат = " + result,
                3 == result);
    }

    @Test
    public void multByZero() {
        double result = calc.mult(3, 0);
        Assert.assertEquals("Операция умножения 3 на 0 не верная. Актуальный результат = " + result,
                0, result, 0);

    }
}