package com.vladislav_sharachev.java.unit_framework.JUnit.testsDemo;

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
    private double pow;
    private double expecedResult;


    public PowTest(double base, double power, double expectedResult) {
        this.base = base;
        this.pow = power;
        this.expecedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static List<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {1, 2, 1},
                {0, 3, 0},
                {3, 0, 1}
        });
    }

    @Test
    public void powTest() {
        double result = new Calculator().pow(base, pow);
        assertEquals("Операция возведения числа " + base + "в степень " + pow + " выполнилась неверно." +
                        " Актуальный результат" + result, expecedResult, result, 0);
    }

}
