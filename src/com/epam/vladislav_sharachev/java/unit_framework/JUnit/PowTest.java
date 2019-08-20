package com.epam.vladislav_sharachev.java.unit_framework.JUnit;

import com.epam.tat.module4.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class PowTest extends Assert {

    private double base;
    private double power;
    private double expectedResult;

    public PowTest(double base, double power, double expectedResult) {
        this.base = base;
        this.power = power;
        this.expectedResult = expectedResult;
    }


    @Parameterized.Parameters
    public static List<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {2, 2, 4},
                {-2, 1, -2},
                {-2, 2, 4},
                {0, 2, 0}
        });
    }

    @Test
    public void powTest() {
        double result = new Calculator().pow(base, power);
        assertEquals("Операция возведения числа " + base + " в степень " + power + " выполнилась неверно. "
                + "Актуальный результат = ", expectedResult, result, 0);
    }
}
