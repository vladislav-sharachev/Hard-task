package com.vladislav_sharachev.java.unit_framework.JUnit.testsDemo;


import com.epam.tat.module4.Calculator;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class SqrtTest extends Assert {

    @DataPoints
    public static  Object[][] testData = new Object[][] {
            {0d, 0d},
            {1d, 1d},
            {4d, 2d}
    };

    @Theory
    public void sqrtTest(final Object ... testData) {
        double result = new Calculator().sqrt((double) testData[0]);
        assertEquals("Операция взятия квадратного корня выполнилась не верно. Актуальный результат = " + result,
                (double) testData[1], result, 0);
    }
}
