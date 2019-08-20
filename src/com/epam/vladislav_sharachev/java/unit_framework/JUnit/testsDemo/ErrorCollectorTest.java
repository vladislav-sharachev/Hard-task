package com.epam.vladislav_sharachev.java.unit_framework.JUnit.testsDemo;

import com.epam.tat.module4.Calculator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ErrorCollectorTest {

    Calculator calc = new Calculator();

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void addTest() {

        Assert.assertEquals(2, calc.sum(0, 1), 0);

    }
}