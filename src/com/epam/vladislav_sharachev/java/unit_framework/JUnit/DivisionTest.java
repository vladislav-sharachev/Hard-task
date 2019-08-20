package com.vladislav_sharachev.java.unit_framework.JUnit;

import com.epam.tat.module4.Calculator;
import com.vladislav_sharachev.java.unit_framework.JUnit.categories.MultAndDiv;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DivisionTest extends Assert {

    Calculator calc = new Calculator();

    @Category(MultAndDiv.class)
    @Test
    public void divThree() {
        double result = calc.mult(3, 3);
        assertEquals("Операция деления 3 на 3 не верная. Актуальный результат = ", 9, result, 0);
    }
    @Category(MultAndDiv.class)
    @Test
    public void divMinus() {
        double result = calc.mult(3, -1);
        assertEquals("Операция деления 3 на -1 не верная. Актуальный результат = ", -3, result, 0);
    }
    @Category(MultAndDiv.class)
    @Test(expected = ArithmeticException.class) //проверка ожидаемого исключения
    public void divZero() {
        double result = calc.mult(3, 0);
    }

}
