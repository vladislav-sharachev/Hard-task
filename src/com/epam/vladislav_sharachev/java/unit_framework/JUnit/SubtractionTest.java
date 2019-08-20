package com.vladislav_sharachev.java.unit_framework.JUnit;

import com.epam.tat.module4.Calculator;
import com.vladislav_sharachev.java.unit_framework.JUnit.categories.SumAndSub;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;


public class SubtractionTest extends Assert {

    Calculator calc = new Calculator();

    @Category(SumAndSub.class)
    @Test
    public void subThree() {
        double result = calc.sub(3, 3);
        assertEquals("Операция вычитания 3 минус 3 не верная. Актуальный результат = ", 0, result, 0);
}
    @Category(SumAndSub.class)
    @Test
    public void subZero() {
        double result = calc.sub(0, 0);
        assertEquals("Операция вычитания 0 минус 0 не верная. Актуальный результат = ", 0, result, 0);
    }
    @Category(SumAndSub.class)
    @Test
    public void subMinus() {
        double result = calc.sub(1, -2);
        assertEquals("Операция вычитания 1 минус -2 не верная. Актуальный результат = ", 3, result, 0);
    }
}