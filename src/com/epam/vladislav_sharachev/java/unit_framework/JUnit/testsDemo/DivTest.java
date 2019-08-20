package com.epam.vladislav_sharachev.java.unit_framework.JUnit.testsDemo;

import com.epam.tat.module4.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class DivTest extends Assert { //деление
    Calculator calc = new Calculator();

    @Test
    public void divByItself() {
        double result = calc.div(3, 3);
        assertEquals("Операция деления 3 на 3 не верная. Актуальный результат = ",
                1, result, 0);
    }

    @Test
    public void divByOneTest() {
        double result = calc.div(3, 1);
        assertEquals("Операция деления 3 на 1 не верная. Актуальный результат = ",
                3, result, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void divByZeroTest() {
        double result = calc.div(3, 0);
    }
}
